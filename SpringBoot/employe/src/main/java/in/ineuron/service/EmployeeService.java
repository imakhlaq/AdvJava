package in.ineuron.service;

import in.ineuron.controller.EmployeeDTO;
import in.ineuron.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeDAO dao;

    @Autowired
    EmployeeService(EmployeeDAO dao) {
        this.dao = dao;
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        String req = scanner.next();
        scanner.close();
        return req;
    }

    @Override
    public EmployeeDTO addNewEmpolyee(EmployeeDTO data) {
        return dao.addNewEmpolyee(data);
    }


    @Override
    public EmployeeData updateEmpolyee(Integer id) {

        EmployeeData emp = this.getEmpolyee(id);
        System.out.println("prevData");
        System.out.println(emp);

        EmployeeDTO update = new EmployeeDTO();
        System.out.println("Enter employee Name");
        String updatedName = getInput();
        if (updatedName.trim().isEmpty()) {
            update.setName(emp.getName());
        } else {
            update.setName(getInput());
        }
        System.out.println("Enter employee Email");
        String updatedEmail = getInput();
        if (updatedEmail.trim().isEmpty()) {
            update.setEmail(emp.getEmail());
        } else {
            update.setEmail(getInput());
        }

        System.out.println("Enter employee DOB (DD/MM/YYYY)");
        String updatedDOB = getInput();
        if (updatedDOB.trim().isEmpty()) {
            update.setDOB(emp.getDOB());
        } else {
            update.setDOB(LocalDate.parse(getInput(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        ;

        return dao.updateEmpolyee(update);
    }

    @Override
    public void deleteEmpolyee(Integer id) {
        dao.deleteEmpolyee(id);
    }

    @Override
    public EmployeeData getEmpolyee(Integer id) {
        return dao.getEmpolyee(id);
    }
}
