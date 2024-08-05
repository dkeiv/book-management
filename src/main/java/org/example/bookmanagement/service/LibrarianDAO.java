package org.example.bookmanagement.service;

import org.example.bookmanagement.dbConnect.DatabaseConnect;
//import org.example.bookmanagement.model.Librarian;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDAO implements ILibrarianDAO {
//    @Override
//    public List<Librarian> ShowAllLibrarian() {
//        String query = "SELECT * FROM librarian";
//
//        List<Librarian> librarianList = new ArrayList<>();
//        try (Connection connection = DatabaseConnect.getCon()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String password = rs.getString("password");
//                librarianList.add(new Librarian(name, email, password));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        return librarianList;
//    }
}
