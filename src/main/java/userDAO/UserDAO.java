package userDAO;

import org.example.bookmanagement.dbConnect.DatabaseConnect;
import org.example.bookmanagement.model.User;

import java.sql.*;
import java.util.ArrayList;
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
        String query = "INSERT INTO user (name, address, course, birthday, active) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnect.getCon()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.setString(3, user.getCourse());
            preparedStatement.setDate(4, user.getBirthday());
            preparedStatement.setBoolean(5, user.isActive());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        String query = "UPDATE user SET name =?, address =?, course =?, birthday =?, active =? WHERE id =?";
        try (Connection connection = DatabaseConnect.getCon(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user.getId());
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
           } else {
               return false;
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
                userList.add(makeUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    private User makeUserFromResultSet(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("id");
        String userName = resultSet.getString("user-name");
        String address = resultSet.getString("address");
        String course = resultSet.getString("course");
        Date birthday = resultSet.getDate("birthday");
        boolean active = resultSet.getBoolean("active");
        return new User(userId, userName, address, course, birthday, active);
    }
}






