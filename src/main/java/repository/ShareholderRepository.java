package repository;

import model.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShareholderRepository {

    private final Connection connection;

    public ShareholderRepository(Connection connection) {
        this.connection = connection;
    }

    public int register(Shareholder shareholder)throws SQLException {

        String registerShareholder = "INSERT INTO shareholder (name, phone_number,national_code) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(registerShareholder);
        preparedStatement.setString(1,shareholder.getName());
        preparedStatement.setString(2,shareholder.getPhoneNumber());
        preparedStatement.setString(3,shareholder.getNationalCode());
        return preparedStatement.executeUpdate();
    }

    public Shareholder delete(Shareholder shareholder) throws SQLException {

        String deleteShareholder = "DELETE FROM shareholder WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteShareholder);
        preparedStatement.setInt(1, shareholder.getId());
        preparedStatement.executeUpdate();
        return shareholder;
    }
}
