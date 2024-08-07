package org.example.bookmanagement.service.userDAO;

import org.example.bookmanagement.dbConnect.DatabaseConnect;
import org.example.bookmanagement.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO implements IUserDAO {
    @Override
    public User getUserById(int id) throws SQLException {
        String query = "SELECT * FROM user WHERE id = ?";

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return makeUserFromResultSet(resultSet);
            }
        }
        return null;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        String query = "INSERT INTO user (name, course, birthday, active) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getCourse());
            preparedStatement.setDate(3, user.getBirthday());
            preparedStatement.setBoolean(4, user.isActive());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateUser(int id, User user) throws SQLException {
        String query = "UPDATE user SET name =?, course =?, birthday =?, active =? WHERE id =?";
        try (Connection connection = DatabaseConnect.getCon(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getCourse());
            statement.setDate(3, user.getBirthday());
            statement.setBoolean(4, user.isActive());
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteUser(User user) throws SQLException {
        String sql = "update user set active = false where id = ?";

        try (Connection connection = DatabaseConnect.getCon()) {
           if (user.isActive() == true) {
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setInt(1, user.getId());

               return preparedStatement.executeUpdate() > 0;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        String query = "SELECT * FROM user";

        List<User> userList = new ArrayList<>();

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = makeUserFromResultSet(resultSet);
                if (user.isActive()) {
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public List<User> searchByName(String name) throws SQLException {
        String query = "select * from user where name like ?;";

        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = makeUserFromResultSet(resultSet);
                if (user.isActive()) {
                    userList.add(user);
                }
            }
            return userList;
        }
    }

    private User makeUserFromResultSet(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("id");
        String userName = resultSet.getString("name");
        String course = resultSet.getString("course");
        Date birthday = resultSet.getDate("birthday");
        boolean active = resultSet.getBoolean("active");
        return new User(userId, userName, course, birthday, active);
    }
}






