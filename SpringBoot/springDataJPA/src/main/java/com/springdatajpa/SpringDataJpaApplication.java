package com.springdatajpa;

import com.springdatajpa.entity.Student;
import com.springdatajpa.service.IStudentService;
import com.springdatajpa.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(SpringDataJpaApplication.class, args);
        IStudentService studentService = context.getBean(StudentService.class);


        Student student = new Student();
        student.setEmail("imakhlaq@gmail.com");
        student.setName("Akhlaq");
        studentService.registerStudent(student);

        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student();
        student1.setEmail("Aman@gmail.com");
        student1.setName("Aman");
        studentList.add(student1);

        Student student12 = new Student();
        student12.setEmail("Azmal@gmail.com");
        student12.setName("Azmal");
        studentList.add(student12);

        //passing list
        studentService.registerInBatch(studentList);


        ((ConfigurableApplicationContext) context).close();
    }

}
