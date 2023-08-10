package in.ineuron;

import in.ineuron.controller.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployApplication.class, args);

        Employee employee = context.getBean(Employee.class);

        employee.choose();
        

    }

}
