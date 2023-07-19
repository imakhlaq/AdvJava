package in.jdbc.main;

//jar given by postgres vendor

import org.postgresql.Driver;

import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Driver driver = new Driver();
        DriverManager.registerDriver(driver);


        // 2 Establish the connection
        String url = "jdbc:postgresql://localhost:5432/java";
        String pss = "sBCA";
        String userid = "postgres";
        Connection connection = DriverManager.getConnection(url, userid, pss);


        // 3 creating statement
        Statement statement = connection.createStatement();

        //4 creating statement object

        //creating table
//        String query = "create table userId(id Integer,name varchar(50) ,age " +
//                "Integer)";

        //inserting into table
//        String query = "insert into userId(id ,name ,age) values(1,'Akhlaq', " +
//                "23),(2,'kaif',24),(3,'Sabir',22),(4,'Arish',23)";

        //5 using statement to get data

        //executing creation table
        // int resultSet = statement.executeUpdate(query);

        //executing update
        //int resultSet = statement.executeUpdate(query);


        //closing the connection
        connection.close();

    }
}
