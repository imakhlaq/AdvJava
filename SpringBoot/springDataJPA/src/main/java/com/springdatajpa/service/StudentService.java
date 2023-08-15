package com.springdatajpa.service;

import com.springdatajpa.dao.IStudentRepo;
import com.springdatajpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService implements IStudentService {


    @Autowired
    private IStudentRepo repo;

    @Override
    public Student registerStudent(Student student) {
        return repo.save(student);

    }

    @Override
    public Iterable<Student> registerInBatch(Iterable<Student> students) {

        return repo.saveAll(students);
    }
}
