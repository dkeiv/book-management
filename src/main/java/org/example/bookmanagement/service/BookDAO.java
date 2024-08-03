package org.example.bookmanagement.service;

import org.example.bookmanagement.dbConnect.DatabaseConnect;
import org.example.bookmanagement.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO {
    @Override
    public boolean deleteBook(int id) throws SQLException {

        String sql = "DELETE FROM book WHERE id = ?";

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
    public void insertBook(Book product) throws SQLException {
        String query = "INSERT INTO book (name, description, publisher, img_url, condition, borrow_status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getPublisher());
            preparedStatement.setString(4, product.getImageURL());
            preparedStatement.setString(5, product.getCondition());
            preparedStatement.setBoolean(6, product.isBorrowed());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(Book product) throws SQLException {

    }

    private Book makeBookFromResultSet(ResultSet resultSet) throws SQLException {
        int bId = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        String publisher = resultSet.getString("publisher");
        String imgUrl = resultSet.getString("img_url");
        String condition = resultSet.getString("condition");
        boolean borrowedStatus = resultSet.getBoolean("borrowed_status");
        return new Book(bId, name, publisher, description, imgUrl, condition, borrowedStatus);
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
}
