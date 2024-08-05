package org.example.bookmanagement.service.bookDAO;

import org.example.bookmanagement.dbConnect.DatabaseConnect;
import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.model.BorrowBook;
import org.example.bookmanagement.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookDAO implements BookDAOInterface {
    // USER DAO goes here

    @Override
    public boolean deleteBook(int id) throws SQLException {

        String sql = "DELETE FROM book WHERE id = ? AND borrow_status = FALSE";

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> getAllBook() {
        String query = "SELECT * FROM book";

        List<Book> bookList = new ArrayList<>();

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookList.add(makeBookFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    @Override
    public Book getBookById(int id) throws SQLException {

        String query = "SELECT * FROM book WHERE id = ?";

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return makeBookFromResultSet(resultSet);
            }
        }

        return null;
    }

    @Override
    public void insertBook(Book book) throws SQLException {
        String query = "INSERT INTO book (isbn, name, description, publisher, img_url, `condition`) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3, book.getDescription());
            preparedStatement.setString(4, book.getPublisher());
            preparedStatement.setString(5, book.getImgUrl());
            preparedStatement.setString(6, book.getCondition());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBookCategory(Book book, String[] categoryIdList) throws SQLException {
        if (categoryIdList == null || categoryIdList.length == 0) {
            return;
        }

        try (Connection connection = DatabaseConnect.getCon()) {
            for (String categoryId : categoryIdList) {
                String query = "INSERT INTO book_category (book_isbn, category_id) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, book.getIsbn());
                preparedStatement.setInt(2, Integer.parseInt(categoryId));

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getCategoryByBookId(int id) throws SQLException {
        String query = "SELECT name FROM category, book_category WHERE category_id = category.id AND book_isbn IN (SELECT isbn FROM book WHERE book.id = ?)";
        List<String> categoryList = new ArrayList<>();

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categoryList.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryList;
    }

    private void updateBookCategory(String[] categoryList) throws SQLException {
        String sql = "UPDATE book SET category = ? WHERE id = ?";
        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (String category : categoryList) {
                preparedStatement.setString(1, category);
            }
        }
    }

    @Override
    public void updateBook(int id, Book book) throws SQLException {
        String query = "{CALL sp_update_book(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseConnect.getCon()) {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, book.getIsbn());
            callableStatement.setString(3, book.getName());
            callableStatement.setString(4, book.getDescription());
            callableStatement.setString(5, book.getPublisher());
            callableStatement.setString(6, book.getImgUrl());
            callableStatement.setString(7, book.getCondition());
            callableStatement.setBoolean(8, book.isBorrowed());
            System.out.println(callableStatement.toString());
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Book makeBookFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String isbn = resultSet.getString("isbn");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        String publisher = resultSet.getString("publisher");
        String imgUrl = resultSet.getString("img_url");
        String condition = resultSet.getString("condition");
        boolean borrowedStatus = resultSet.getBoolean("borrow_status");
        return new Book(id, isbn, name, publisher, description, imgUrl, condition, borrowedStatus);
    }

    public List<String> getBookCategory() throws SQLException {
        List<String> categoryList = new ArrayList<>();
        String query = "SELECT name FROM category, book_category WHERE category_id = category.id AND book_id = ?";
        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categoryList.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public List<Category> getAllCategory() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        String query = "SELECT * FROM category";
        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                categoryList.add(new Category(id, name));
            }
        }
        return categoryList;
    }

    public List<String> getAllPublisher() throws SQLException {
        List<String> publisherList = new ArrayList<>();
        String query = "SELECT * FROM publisher";

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                publisherList.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publisherList;
    }

    @Override
    public Book getBookByIsbn(String isbn) throws SQLException {
        String query = "SELECT * FROM book WHERE isbn = ?";

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return makeBookFromResultSet(resultSet);
            }
        }
        return null;
    }

    @Override
    public void insertBorrowBook(BorrowBook borrowBook) throws SQLException {
        String query = "INSERT INTO borrow_book (user_id, book_isbn, status, borrow_date, return_date) VALUES (?, ?, ?, ?, ?)";
        String query2= "UPDATE book SET borrow_status = TRUE WHERE isbn = ?";
        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, borrowBook.getUserId());
            preparedStatement.setString(2, borrowBook.getBookIsbn());
            preparedStatement.setString(3, borrowBook.getStatus());
            preparedStatement.setDate(4, borrowBook.getBorrowDate());
            preparedStatement.setDate(5, borrowBook.getReturnDate());
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setString(1, borrowBook.getBookIsbn());
            preparedStatement2.executeUpdate();
        }
    }

    @Override
    public List<BorrowBook> getAllBorrowBook() throws SQLException {
        List<BorrowBook> borrowBookList = new ArrayList<>();
        String query = "SELECT * FROM borrow_book";

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String bookIsbn = resultSet.getString("book_isbn");
                String status = resultSet.getString("status");
                Date borrowDate = resultSet.getDate("borrow_date");
                Date returnDate = resultSet.getDate("return_date");

                borrowBookList.add(new BorrowBook(id, userId, bookIsbn, status, borrowDate, returnDate));
            }
        }
        return borrowBookList;
    }

    @Override
    public BorrowBook getBorrowBookById(int id) throws SQLException {
        String query = "SELECT * FROM borrow_book WHERE id = ?";
        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int borrowId = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String bookIsbn = resultSet.getString("book_isbn");
                String status = resultSet.getString("status");
                Date borrowDate = resultSet.getDate("borrow_date");
                Date returnDate = resultSet.getDate("return_date");

                return new BorrowBook(borrowId, userId, bookIsbn, status, borrowDate, returnDate);
            }
        }
        return null;
    }

    @Override
    public List<BorrowBook.Status> getBorrowedStatus() throws SQLException {
        return Arrays.asList(BorrowBook.Status.values());
    }
}