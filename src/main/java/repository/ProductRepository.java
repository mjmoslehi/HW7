package repository;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepository {
    private final Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public int register(Product product)throws SQLException {
        String registerProduct = "INSERT INTO product (name, create_date, category_id, brand_id) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(registerProduct);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setDate(2,product.getCreateDate());
        preparedStatement.setInt(3,product.getCategoryId());
        preparedStatement.setInt(4,product.getBrandId());
        return preparedStatement.executeUpdate();
    }

    public Product delete(Product product) throws SQLException {
        String deleteProduct = "DELETE FROM product WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteProduct);
        preparedStatement.setInt(1, product.getId());
        preparedStatement.executeUpdate();
        return product;
    }
}
