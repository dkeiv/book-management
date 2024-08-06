package org.example.bookmanagement.service.categoryDAO;

import org.example.bookmanagement.dbConnect.DatabaseConnect;
import org.example.bookmanagement.model.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.*;


public class CategoryDAO implements ICategoryDAO{
    private static final String CREATE_CATEGORY = "INSERT INTO category (name) VALUES (?)";
    private static final String UPDATE_CATEGORY = "UPDATE category SET name =? WHERE id =?";
    private static final String DELETE_CATEGORY = "DELETE FROM category WHERE id =?";
    private static final String GET_CATEGORY_BY_ID = "SELECT * FROM category WHERE id =?";
    private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM category";
    @Override
    public void createCategory(Category category) throws SQLException {
        try (Connection connection = DatabaseConnect.getCon();
        PreparedStatement statement = connection.prepareStatement(CREATE_CATEGORY)) {
            statement.setString(1, category.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateCategory(int id, Category category) throws SQLException {
        try (Connection connection = DatabaseConnect.getCon();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY)) {
            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteCategory(Category category) throws SQLException {
        try (Connection connection = DatabaseConnect.getCon(); PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY)) {
            statement.setInt(1, category.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean setIdCategoryToNull() throws SQLException {
        String query = "UPDATE book SET email = NULL WHERE id = 1";
        return false;
    }

    @Override
    public Category getCategoryById(int id) throws SQLException {
        Category category = null;
        try (Connection connection = DatabaseConnect.getCon(); PreparedStatement statement = connection.prepareStatement(GET_CATEGORY_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int categoryId = resultSet.getInt("id");
                String categoryName = resultSet.getString("name");
                category = new Category(categoryId, categoryName);
            }
        }
        return category;
    }

    @Override
    public List<Category> selectAllCategory() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = DatabaseConnect.getCon();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CATEGORIES)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                categories.add(new Category(resultSet.getInt("id"), resultSet.getString("name")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Category> searchCategoryByName(String name) throws SQLException {
        String category = "select * form category where name like ?;";
        try (Connection connection = DatabaseConnect.getCon();) {
            PreparedStatement statement = connection.prepareStatement(category);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            List<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                categories.add(new Category(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return categories;
        }
    }
}
