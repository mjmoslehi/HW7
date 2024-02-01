package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public int register(User user)throws SQLException {
        String registerUser = "INSERT INTO users (name, username, email, password) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(registerUser);
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getUserName());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        return preparedStatement.executeUpdate();
    }
}
