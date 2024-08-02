package org.example.bookmanagement.service;

import org.example.bookmanagement.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookDAO {

    Book getBookById(int id) throws SQLException;

    void insertBook(Book product) throws SQLException;

    void updateBook(Book product) throws SQLException;

    boolean deleteBook(int id) throws SQLException;

    List<Book> getAllBook();

//    List<String> getAllCategory();

//    List<Book> searchBook(String name, String price, String category, String color);
}
