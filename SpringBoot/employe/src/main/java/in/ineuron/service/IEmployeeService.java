package in.ineuron.service;

import in.ineuron.controller.EmployeeDTO;

public interface IEmployeeService {
    EmployeeData addNewEmpolyee(EmployeeDTO data);

    EmployeeData updateEmpolyee(Integer id);

    EmployeeData deleteEmpolyee(Integer id);

    EmployeeData getEmpolyee(Integer id);


}
