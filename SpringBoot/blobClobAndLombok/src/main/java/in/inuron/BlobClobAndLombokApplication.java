package in.inuron;

import in.inuron.model.Student;
import in.inuron.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

@SpringBootApplication
public class BlobClobAndLombokApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(BlobClobAndLombokApplication.class, args);

        StudentService service = context.getBean(StudentService.class);

        //saving student
        Student student = new Student();

        student.setName("Akhlaq");
        student.setEmail("imakhlaqXD@gmail.com");
        student.setDOB(LocalDate.of(1999, 10, 3));

        //reading Photo as binary

        File photoFile = new File("F:\boat.png");
        File charFile = new File("F:\tero.txt");
        try (FileInputStream fis = new FileInputStream(photoFile);) {

            byte[] bytes = fis.readAllBytes();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //reading character file
    }

}
