package org.example.bookmanagement.service.librarianDAO;

import org.example.bookmanagement.dbConnect.DatabaseConnect;
import org.example.bookmanagement.model.Librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDAO implements ILibrarianDAO {

    public LibrarianDAO() {
        // Constructor can be used for initialization if needed
    }

    @Override
    public List<Librarian> showAllLibrarian() {
        List<Librarian> librarianList = new ArrayList<>();
        String query = "SELECT * FROM librarian";
        try (Connection connection = DatabaseConnect.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                librarianList.add(new Librarian(id, name, email, password));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching librarians", e);
        }
        return librarianList;
    }

    @Override
    public void insertLibrarian(Librarian librarian) {
        String query = "INSERT INTO librarian(name, email, password) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnect.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, librarian.getName());
            preparedStatement.setString(2, librarian.getEmail());
            preparedStatement.setString(3, librarian.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting librarian", e);
        }
    }

    @Override
    public boolean updateLibrarian(Librarian librarian) {
        boolean rowUpdated = false;
        String query = "UPDATE librarian SET name = ?, email = ?, password = ? WHERE id = ?";
        try (Connection connection = DatabaseConnect.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, librarian.getName());
            preparedStatement.setString(2, librarian.getEmail());
            preparedStatement.setString(3, librarian.getPassword());
            preparedStatement.setInt(4, librarian.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating librarian", e);
        }
        return rowUpdated;
    }

    @Override
    public Librarian searchByID(int id) {
        Librarian librarian = null;
        String query = "SELECT * FROM librarian WHERE id = ?";
        try (Connection connection = DatabaseConnect.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    int librarianId = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    librarian = new Librarian(librarianId, name, email, password);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding librarian by ID", e);
        }
        return librarian;
    }

    @Override
    public boolean deleteLibrarian(int id) {
        boolean rowDeleted = false;
        String query = "DELETE FROM librarian WHERE id = ?";
        try (Connection connection = DatabaseConnect.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting librarian", e);
        }
        return rowDeleted;
    }

    @Override
    public List<Librarian> searchByName(String name) {
        List<Librarian> librarianList = new ArrayList<>();
        String query = "SELECT * FROM librarian where name = ?";
        try (Connection connection = DatabaseConnect.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameLibrarian = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                librarianList.add(new Librarian(id, nameLibrarian, email, password));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return librarianList;
    }
}
