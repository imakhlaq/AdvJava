package in.inuron;

import in.inuron.model.Student;
import in.inuron.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.*;
import java.time.LocalDate;
import java.util.stream.Stream;

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
        File photoFile = new File("F:\\boat.png");

        //reading character file
        File charFile = new File("F:\\tero.txt");
        try (FileInputStream fis = new FileInputStream(photoFile); BufferedReader bis = new BufferedReader(new FileReader(charFile))) {

            byte[] bytes = fis.readAllBytes();
            student.setPhoto(bytes);

            char[] chars = new char[(int) charFile.length()];
            bis.read(chars);

            student.setBioData(chars);

            service.addNewStudent(student);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
