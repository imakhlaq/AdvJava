package in.inuron.service;

import in.inuron.documents.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Student registerCustomer(Student student);

    List<Student> findAllStudents();

    Optional<Student> findStudentById(String id);

    String removeStudent(String id);

    List<Student> byName(String name);

}
