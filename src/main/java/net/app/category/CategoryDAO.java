package net.app.category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.app.user.ConnectionManager;

public class CategoryDAO {

    private static final String INSERT_CATEGORY_SQL = "INSERT INTO Categories" + "  (CategoryID, CategoryName) VALUES "
            + " (?, ?);";

    private static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM Categories WHERE CategoryID = ?";
    private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM Categories";
    private static final String DELETE_CATEGORY_SQL = "DELETE FROM Categories WHERE CategoryID = ?;";

    public CategoryDAO() {
    }

    protected Connection getConnection() throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        return connectionManager.getConnection();
    }

    public void insertCategory(Category category) throws SQLException {
        System.out.println(INSERT_CATEGORY_SQL);
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setInt(1, category.getCategoryID());
            preparedStatement.setString(2, category.getCategoryName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Category selectCategory(int id) {
        Category category = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int categoryID = rs.getInt("CategoryID");
                String categoryName = rs.getString("CategoryName");
                category = new Category(categoryID, categoryName);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }

    public List<Category> selectAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int categoryID = rs.getInt("CategoryID");
                String categoryName = rs.getString("CategoryName");
                categories.add(new Category(categoryID, categoryName));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categories;
    }

    public boolean deleteCategory(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
