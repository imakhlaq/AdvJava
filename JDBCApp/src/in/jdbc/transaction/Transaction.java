package in.jdbc.transaction;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Transaction {

    public static void main(String[] args) throws IOException, SQLException {

        //Loading properties from jdbc.properties (with properties Map)
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Java\\JDBCApp\\src" +
                "\\jdbc.properties");
        properties.load(fis);

        PGConnectionPoolDataSource pgPool = new PGConnectionPoolDataSource();

        pgPool.setURL(properties.getProperty("URL"));
        pgPool.setPassword(properties.getProperty("PASS"));
        pgPool.setUser(properties.getProperty("USER_ID"));

        Connection connection = pgPool.getConnection();

        String query = "SELECT * FROM users_info";

        PreparedStatement preparedStatement = connection.prepareStatement(query);


    }
}
