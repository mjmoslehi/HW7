package repository;

import model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BrandRepository {
    private final Connection connection;

    public BrandRepository(Connection connection) {
        this.connection = connection;
    }

    public int registerBrand(Brand brand) throws SQLException {
        String addBrand = "INSERT INTO brand (name, website, description) VALUES (?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(addBrand);
        preparedStatement.setString(1, brand.getName());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());
        return preparedStatement.executeUpdate();
    }
}
