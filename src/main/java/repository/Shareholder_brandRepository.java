package repository;

import java.sql.Connection;

public class Shareholder_brandRepository {
    private final Connection connection;

    public Shareholder_brandRepository(Connection connection) {
        this.connection = connection;
    }
}
