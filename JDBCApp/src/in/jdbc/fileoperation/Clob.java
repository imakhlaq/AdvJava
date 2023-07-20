package in.jdbc.fileoperation;

import java.io.*;
import java.sql.*;

class connect {

    public static Connection connection() throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/java";
        String pss = "sBCA";
        String userid = "postgres";

        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(url, userid, pss);
    }
}


public class Clob {

    public static void main(String[] args) {

        try {
            Connection connection = connect.connection();


            //Reading from a file to database

//            BufferedReader bff = new BufferedReader(new FileReader("C:\\Users" +
//                    "\\Administrator\\Downloads\\deatail.txt"));
//
//            //
//            String query = "INSERT INTO cities(name,details) VALUES(?,?)";
//
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement(query);
//
//            preparedStatement.setString(1, "Siwan");
//            preparedStatement.setCharacterStream(2, bff);
//            preparedStatement.executeUpdate();

            //Writing to a file from database

            PrintWriter pw = new PrintWriter("D:\\Projects\\detail.txt");

            String querry = "SELECT name , details FROM cities";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(querry);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println(resultSet.getString(1));

                Reader rd = resultSet.getCharacterStream(2);

                rd.transferTo(pw);

                pw.flush();
            }

        } catch (SQLException | ClassNotFoundException |
                 FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
