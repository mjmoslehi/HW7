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

}
