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


/*        Student student = new Student();
        student.setEmail("jigg@gmail.com");
        student.setName("PRX jigg");
        System.out.println(service.registerCustomer(student));*/


        // service.findAllStudents().forEach(System.out::println);

        //  System.out.println(service.findStudentById("64e0eaf825e81a43d3abbabb").get());

        //System.out.println(service.removeStudent("64e0d8c88bf98a2220f080f7"));

        System.out.println(service.byName("PRX jigg"));

    }

}
