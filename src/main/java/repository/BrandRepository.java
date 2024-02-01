package repository;

import model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Brand[] loadAllBrand() throws SQLException {
        String loadBrands = "SELECT * FROM brand ";
        PreparedStatement preparedStatement = connection.prepareStatement(loadBrands,
                ResultSet.TYPE_SCROLL_SENSITIVE ,
                ResultSet.TYPE_SCROLL_INSENSITIVE);
        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;
        while (resultSet.next()) {
            count++;
        }

        Brand[] brands = new Brand[count];
        int i = 0;

        resultSet.beforeFirst();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String website = resultSet.getString("website");
            String description = resultSet.getString("description");

            brands[i] = new Brand(id, name, website, description);
            System.out.println(brands[i]);
            i++;
        }
        return brands;
    }
}
