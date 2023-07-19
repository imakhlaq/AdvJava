package in.jdbc.main;

import java.sql.*;

public class NewJDBCConnection {
    public static void main(String[] args) throws SQLException {

        //resources used
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        //establish the connection
        String url = "jdbc:postgresql://localhost:5432/java";
        String userid = "postgres";
        String pss = "sBCA";


        try {
            //loading vendor Driver "Auto loading"
            Class.forName("org.postgresql.Driver");

            //creating connection
            connection = DriverManager.getConnection(url, userid, pss);
            if (connection == null) return;

            //preparing statement
            statement = connection.createStatement();
            if (statement == null) return;

            String query = "select * from userid";

            //processing result set
            resultSet = statement.executeQuery(query);
            if (resultSet == null) return;

            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Integer age = resultSet.getInt(3);
                System.out.println(id + " " + name + " " + age);
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //closing connection
            assert connection != null;
            connection.close();
        }
    }
}
