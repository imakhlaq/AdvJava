package in.ineuron.dao;


import in.ineuron.controller.EmployeeDTO;
import in.ineuron.service.EmployeeData;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeDAO implements IEmpolyeeDAO {
    @Override
    public EmployeeData addNewEmpolyee(EmployeeDTO data) {
        return null;
    }

    @Override
    public EmployeeData updateEmpolyee(Integer id) {
        return null;
    }

    @Override
    public EmployeeData deleteEmpolyee(Integer id) {
        return null;
    }

    @Override
    public EmployeeData getEmpolyee(Integer id) {
        return null;
    }
}
