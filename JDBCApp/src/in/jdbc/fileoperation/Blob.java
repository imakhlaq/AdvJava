package in.jdbc.fileoperation;

import java.io.*;
import java.sql.*;

class Operations {

    public static Connection getConnection() throws ClassNotFoundException,
            SQLException {


        String url = "jdbc:postgresql://localhost:5432/java";
        String pss = "sBCA";
        String userid = "postgres";

        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(url, userid, pss);
    }
}

public class Blob {
    public static void main(String[] args) throws IOException, SQLException {

        Connection connection = null;


        try {

            connection = Operations.getConnection();

            //String query = "SELECT name, photo FROM photos ";

//            String query = "INSERT INTO photos(name,photo) VALUES (?,?)";
//
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement(query);
//
//
//            // for binary data use stream
//            File f = new File("C:\\Users\\Administrator\\Downloads" +
//                    "\\Screenshot" +
//                    " " +
//                    "2023-07-20 155015.png");
//              FileInputStream fis  = new FileInputStream(f);
//
//            preparedStatement.setString(1, "Mufti image");
//            preparedStatement.setBytes(2, fis.readAllBytes());
//
//            preparedStatement.executeUpdate();

            String query = "SELECT name,photo FROM photos";


            PreparedStatement preparedStatement = connection.prepareStatement(query);

            File file = new File("D:\\Projects\\download.jpg");

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println(resultSet.getString(1));
                byte[] arr = resultSet.getBytes(2);
                fileOutputStream.write(arr);

            }

        } catch (SQLException | ClassNotFoundException |
                 FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            assert connection != null;
            connection.close();
        }


    }
}
