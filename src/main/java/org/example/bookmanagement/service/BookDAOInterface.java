package org.example.bookmanagement.service;

import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.model.BorrowDetail;
import org.example.bookmanagement.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface BookDAOInterface {

    Book getBookById(int id) throws SQLException;

    void insertBook(Book book) throws SQLException;

    void updateBook(int id, Book book) throws SQLException;

    boolean deleteBook(int id) throws SQLException;

    List<Book> getAllBook();

    List<String> getAllPublisher() throws SQLException;

    List<Category> getAllCategory() throws SQLException;

    void borrowBook(BorrowDetail detail) throws SQLException;

    BorrowDetail getBorrowDetail(int id) throws SQLException;

    void addBookCategory(Book book, String[] categoryIdList) throws SQLException;

    List<String> getCategoryByBookId(int id) throws SQLException;
//    List<String> getAllCategory();

//    List<Book> searchBook(String name, String price, String category, String color);
}
