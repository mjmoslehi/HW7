package repository;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
