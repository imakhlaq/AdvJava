package com.springdatajpa.service;

import com.springdatajpa.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentService {
    //single Student
    Student registerStudent(Student student);

    //batch/Multiple Student Save as once
    Iterable<Student> registerInBatch(Iterable<Student> students);
}
