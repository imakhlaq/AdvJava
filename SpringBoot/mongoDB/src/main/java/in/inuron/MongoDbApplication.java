package in.inuron;

import in.inuron.documents.Student;
import in.inuron.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MongoDbApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(MongoDbApplication.class, args);

        StudentService service = context.getBean(StudentService.class);


        Student student = new Student();
        student.setEmail("imakhlaq@gmail.com");
        student.setName("Akhlaq");


        System.out.println(service.registerCustomer(student));
    }

}
