package repository;

import model.Product;

import java.sql.*;

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

    public Product load(int productId)throws SQLException{
        String loadProduct = "SELECT * FROM product WHERE id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(loadProduct);
        preparedStatement.setInt(1,productId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            int id = resultSet.getInt("id");
            String name =resultSet.getString("name");
            Date createDate = resultSet.getDate("create_date");
            int categoryId =resultSet.getInt("category_id");
            int brandId = resultSet.getInt("brand_id");
            Product product = new Product(id , name , createDate ,categoryId ,brandId);
            return product;
        }else return null;
    }
}
