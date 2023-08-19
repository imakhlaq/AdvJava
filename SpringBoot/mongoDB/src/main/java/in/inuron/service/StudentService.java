package in.inuron.service;

import in.inuron.documents.Student;
import in.inuron.repos.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepo repo;

    @Override
    public Student registerCustomer(Student student) {

        return repo.insert(student);

    }
}
