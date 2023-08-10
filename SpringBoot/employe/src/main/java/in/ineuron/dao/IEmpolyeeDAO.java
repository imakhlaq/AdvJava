package in.ineuron.dao;

import in.ineuron.controller.EmployeeDTO;
import in.ineuron.service.EmployeeData;

public interface IEmpolyeeDAO {

    EmployeeData addNewEmpolyee(EmployeeDTO data);

    EmployeeData updateEmpolyee(EmployeeDTO id);

    EmployeeData deleteEmpolyee(Integer id);

    EmployeeData getEmpolyee(Integer id);


}
