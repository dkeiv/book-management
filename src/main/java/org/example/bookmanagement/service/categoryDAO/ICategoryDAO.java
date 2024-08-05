package org.example.bookmanagement.service.categoryDAO;

import org.example.bookmanagement.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO {
    void createCategory(Category category) throws SQLException;

    boolean updateCategory(int id, Category category) throws SQLException;

    boolean deleteCategory(Category category) throws SQLException;

    Category getCategoryById(int id) throws SQLException;

    List<Category> selectAllCategory();
}
