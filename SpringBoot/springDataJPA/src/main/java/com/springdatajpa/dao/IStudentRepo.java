package com.springdatajpa.dao;

import com.springdatajpa.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepo extends CrudRepository<Student, Integer> {
}
