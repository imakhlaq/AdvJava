package in.inuron.service;


import in.inuron.dao.IStudentDao;
import in.inuron.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentDao repo;
    
    @Override
    public Student addNewStudent(Student student) {
        return repo.save(student);
    }
}
