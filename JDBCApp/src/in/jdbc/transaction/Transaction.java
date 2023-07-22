package in.jdbc.transaction;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Transaction {

    public static void main(String[] args) throws IOException, SQLException {

        //Loading properties from jdbc.properties (with properties Map)
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Java\\JDBCApp\\src" +
                "\\jdbc.properties");
        properties.load(fis);


        //connection pool
        PGConnectionPoolDataSource pgPool = new PGConnectionPoolDataSource();

        pgPool.setURL(properties.getProperty("URL"));
        pgPool.setPassword(properties.getProperty("PASS"));
        pgPool.setUser(properties.getProperty("USER_ID"));

        Connection connection = pgPool.getConnection();


        //setting auto commit to false so it will not commit
        connection.setAutoCommit(false);
        String SenderQuery = "UPDATE bank SET money=money-? WHERE id=1";
        String ReceiverQuery = "UPDATE bank SET money = money+? WHERE id=?";


        connection.createStatement().executeUpdate("UPDATE bank SET " +
                "money=money-3000 WHERE id=1");


        connection.createStatement().executeUpdate("UPDATE bank SET " +
                "money = money+3000 WHERE id=2");


        ResultSet rs = connection.createStatement().executeQuery("select * " +
                "from" +
                " bank where id=1");

        while (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getInt(3));
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("CONFIRM THE TRANSACTION");
        String confirm = sc.next();

        if (confirm.equalsIgnoreCase("yes")) {
            //commit All grouped Statement
            connection.commit();

        } else {
            System.out.println("TRANSACTION FAILED");
            //Rollback All grouped Statement
            connection.rollback();
        }


    }
}
