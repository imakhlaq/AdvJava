package in.jdbc.main;

import java.sql.*;

public class PreCompiledQuery {

    public static void main(String[] args) {

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;


        //establish the connection
        String url = "jdbc:postgresql://localhost:5432/java";
        String userid = "postgres";
        String pss = "sBCA";


        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, userid, pss);
            if (connection == null) return;

            //preparing query
            String query = "select * from userid where id=?";

            //sending prepare query
            preparedStatement = connection.prepareStatement(query);
            int id = 2;
            //setting place holder
            preparedStatement.setInt(1, id);

            //executing
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Integer id2 = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Integer age = resultSet.getInt(3);
                System.out.println(id2 + " " + name + " " + age);
            }

            //  using again
            int id3 = 3;
            preparedStatement.setInt(1, id3);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Integer id2 = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Integer age = resultSet.getInt(3);
                System.out.println(id2 + " " + name + " " + age);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
