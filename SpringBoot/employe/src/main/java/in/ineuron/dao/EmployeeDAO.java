package in.ineuron.dao;


import in.ineuron.controller.EmployeeDTO;
import in.ineuron.service.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class EmployeeDAO implements IEmpolyeeDAO {


    private DataSource dataSource;

    @Autowired
    EmployeeDAO(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public EmployeeDTO addNewEmpolyee(EmployeeDTO data) {
        try (Connection connection = this.getConnection()) {

            connection.setAutoCommit(false);
            String query = "INSERT INTO employee(id,name,dob,email) VALUES (?,?,?,?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, 1);
            pre.setString(2, data.getName());
            pre.setDate(3, new Date(Date.valueOf(data.getDOB()).getTime()));
            pre.setString(4, data.getEmail());

            pre.executeUpdate();
            connection.commit();

            return data;

        } catch (SQLException e) {
            System.out.println("Record not Inserted");
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public EmployeeData updateEmpolyee(EmployeeDTO id) {
        try (Connection connection = this.getConnection()) {
            String query = "INSERT INTO employee(id,name,DOB,email) VALUES (?,?,?,?)";
            PreparedStatement pre = connection.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println("Record not Inserted");
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void deleteEmpolyee(Integer id) {
        try (Connection connection = this.getConnection()) {
            String query = "DELETE FROM employee where id= ?";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, id);
            pre.executeUpdate();
            System.out.println("Employee deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public EmployeeData getEmpolyee(Integer id) {

        try (Connection connection = this.getConnection()) {
            String query = "SELECT id,name,dob,email FROM employee where id = ?";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, id);
            ResultSet resultSet = pre.executeQuery();

            EmployeeData ep = new EmployeeData();

            while (resultSet.next()) {

                ep.setId(resultSet.getInt(1));
                ep.setEmail(resultSet.getString(4));
                ep.setName(resultSet.getString(2));
                ep.setDOB(resultSet.getDate(3).toLocalDate());
            }


            return ep;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
