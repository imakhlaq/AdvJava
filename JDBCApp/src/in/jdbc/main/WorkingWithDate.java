package in.jdbc.main;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class WorkingWithDate {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Scanner scanner = null;

        //establish the connection
        String url = "jdbc:postgresql://localhost:5432/java";
        String userid = "postgres";
        String pss = "sBCA";


        try {

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, userid, pss);


            //create table with id, name, DOB, JDate
//            String createTable = "CREATE TABLE users_info(id SERIAL PRIMARY " +
//                    "KEY," +
//                    " name VARCHAR(30), DOB DATE, join_date DATE)";
//            preparedStatement = connection.prepareStatement(createTable);
//            preparedStatement.executeUpdate();

            //creating a user in table
            scanner = new Scanner(System.in);
            System.out.print("NAME : ");
            String name = scanner.nextLine();
            System.out.print("AGE : ");
            Integer age = scanner.nextInt();
            System.out.print("DOB : ");
            String DOB = scanner.next();


            String createUser = "INSERT INTO users_info(name,DOB,join_date) " +
                    "VALUES (?,?,?)";

            preparedStatement = connection.prepareStatement(createUser);

            //date object and parsing it using special pattern
            LocalDate DOBdate = LocalDate.parse(DOB,
                    DateTimeFormatter.ofPattern("dd-MM-yyyy"));


            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, new Date(Date.valueOf(DOBdate).getTime()));
            preparedStatement.setTimestamp(3,
                    new Timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime()));
            preparedStatement.executeUpdate();


            //reading user data
            Integer id = scanner.nextInt();

            String getQuery = "SELECT name,DOB,join_date FROM users_info WHERE id= ?";

            preparedStatement = connection.prepareStatement(getQuery);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nameOut = resultSet.getString(1);
                LocalDate DOBOut = resultSet.getDate(2).toLocalDate();

                Timestamp join = resultSet.getTimestamp(3);

                System.out.println(nameOut + " " + DOBOut + " " + join);

            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            assert scanner != null;
            scanner.close();

        }
    }
}
