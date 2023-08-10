package in.ineuron.controller;


import in.ineuron.service.EmployeeData;
import in.ineuron.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class Employee implements IEmployee {


    IEmployeeService employeeService;

    @Autowired
    Employee(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        String req = scanner.next();
        scanner.close();
        return req;
    }

    public void choose() {
        System.out.println("1 To add new Employee");
        System.out.println("2 To get Employee data");
        System.out.println("3 To Update Employee data");
        System.out.println("4 To delete Employee");
        String req = getInput();

        if ("1".equals(req)) addNewEmpolyee();
        else if ("2".equals(req)) getEmpolyee();
        else if ("3".equals(req)) updateEmpolyee();
        else deleteEmpolyee();
    }


    @Override
    public void addNewEmpolyee() {

        EmployeeDTO emp = new EmployeeDTO();
        System.out.println("Enter employee Name");
        emp.setName(getInput());

        System.out.println("Enter employee DOB (DD/MM/YYYY)");
        emp.setDOB(LocalDate.parse(getInput(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        System.out.println("Enter employee Email");
        emp.setEmail(getInput());

        EmployeeData data = employeeService.addNewEmpolyee(emp);
        System.out.println(data);
    }

    @Override
    public void updateEmpolyee() {

    }

    @Override
    public void deleteEmpolyee() {

    }

    @Override
    public void getEmpolyee() {

    }
}
