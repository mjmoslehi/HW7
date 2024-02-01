package repository;

import model.Shareholder_Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Shareholder_brandRepository {
    private final Connection connection;

    public Shareholder_brandRepository(Connection connection) {
        this.connection = connection;
    }

    public int register(Shareholder_Brand shareholderBrand) throws SQLException {
        String registerShareholderBrand = "INSERT INTO shareholder_brand VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(registerShareholderBrand);
        preparedStatement.setInt(1,shareholderBrand.getIdShareholder());
        preparedStatement.setInt(2,shareholderBrand.getIdBrand());
        return preparedStatement.executeUpdate();
    }

    public Shareholder_Brand delete(Shareholder_Brand shareholderBrand)throws SQLException{
        String deleteShareholderBrand ="DELETE FROM shareholder_brand WHERE id = ?";
        PreparedStatement preparedStatement =connection.prepareStatement(deleteShareholderBrand);
        preparedStatement.setInt(1,shareholderBrand.getId());
        preparedStatement.executeUpdate();
        return shareholderBrand;
    }

    public Shareholder_Brand load (int shBrId) throws SQLException{

        String loadShBr = "SELECT * FROM shareholder_brand WHERE id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(loadShBr );
        preparedStatement.setInt(1,shBrId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            int id = resultSet.getInt("id");
            int idShareholder = resultSet.getInt("id_shareholder");
            int idBrand = resultSet.getInt("id_brand");
            Shareholder_Brand shareholderBrand = new Shareholder_Brand(id , idShareholder ,idBrand);
            return shareholderBrand;
        }else return null;

    }
}
