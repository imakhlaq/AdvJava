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

public class FileOperation {
    public static void main(String[] args) throws IOException, SQLException {

        Connection connection = null;

        FileInputStream fis = null;


        try {

            connection = Operations.getConnection();

            //String query = "SELECT name, photo FROM photos ";

            String query = "INSERT INTO photos(name,photo) VALUES (?,?)";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);


            // for binary data use stream
            File f = new File("C:\\Users\\Administrator\\Downloads" +
                    "\\Screenshot" +
                    " " +
                    "2023-07-20 155015.png");
            fis = new FileInputStream(f);

            preparedStatement.setString(1, "Mufti image");
            preparedStatement.setBytes(2, fis.readAllBytes());

            preparedStatement.executeUpdate();


        } catch (SQLException | ClassNotFoundException |
                 FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert fis != null;
            fis.close();
            connection.close();
        }


    }
}
