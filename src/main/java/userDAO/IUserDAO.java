package userDAO;

import org.example.bookmanagement.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {

    User getUserById(int id) throws SQLException;

    void insertUser(User user) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    boolean deleteUser(User user) throws SQLException;

    List<User> getAllUser();

}
