package in.ineuron.dao;

import in.ineuron.controller.EmployeeDTO;
import in.ineuron.service.EmployeeData;

public interface IEmpolyeeDAO {

    EmployeeDTO addNewEmpolyee(EmployeeDTO data);

    EmployeeData updateEmpolyee(EmployeeDTO id);

    void deleteEmpolyee(Integer id);

    EmployeeData getEmpolyee(Integer id);


}
