package in.ineuron.service;

import in.ineuron.controller.EmployeeDTO;

public interface IEmployeeService {
    EmployeeDTO addNewEmpolyee(EmployeeDTO data);

    EmployeeData updateEmpolyee(Integer id);

    void deleteEmpolyee(Integer id);

    EmployeeData getEmpolyee(Integer id);


}
