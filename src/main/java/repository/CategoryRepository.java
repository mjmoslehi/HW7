package repository;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepository {
    private final Connection connection;

    public CategoryRepository(Connection connection) {
        this.connection = connection;
    }

    public int register(Category category) throws SQLException {

        String registerCategory = "INSERT INTO category (name, description) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(registerCategory);
        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getDescription());
        return preparedStatement.executeUpdate();
    }

    public Category[] loadAllCategory() throws SQLException {

        String loadCategories = "SELECT * FROM category ";
        PreparedStatement preparedStatement = connection.prepareStatement(loadCategories ,
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.TYPE_SCROLL_INSENSITIVE);
        ResultSet resultSet = preparedStatement.executeQuery();
        int count = 0;

        while (resultSet.next()) {
            count++;
        }

        Category[] categories = new Category[count];

        int i = 0;
        resultSet.beforeFirst();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            categories[i] = new Category(id, name, description);
            System.out.println(categories[i]);
            i++;
        }
        return categories;
    }

    public Category delete(Category category) throws SQLException {

        String deleteCategory = "DELETE FROM brand WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteCategory);
        preparedStatement.setInt(1, category.getId());
        preparedStatement.executeUpdate();
        return category;
    }

    public Category load (int categoryId) throws SQLException{

        String loadCategory = "SELECT * FROM category WHERE id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(loadCategory);
        preparedStatement.setInt(1,categoryId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            int id = resultSet.getInt("id");
            String name =resultSet.getString("name");
            String description = resultSet.getString("description");
            Category category = new Category(id , name , description);
            return category;
        }else return null;

    }

    public Category edit(Category category) throws SQLException {
        String editCategory = "UPDATE brand SET name = ? ,description =? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(editCategory);
        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getDescription());
        preparedStatement.setInt(3, category.getId());
        preparedStatement.executeUpdate();
        return category;
    }

}
