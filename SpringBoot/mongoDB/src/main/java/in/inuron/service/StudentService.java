package in.inuron.service;

import in.inuron.documents.Student;
import in.inuron.repos.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepo repo;

    @Autowired
    MongoTemplate template;

    @Override
    public Student registerCustomer(Student student) {
        return repo.insert(student);

    }

    @Override
    public List<Student> findAllStudents() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return repo.findAll(sort);
    }

    @Override
    public Optional<Student> findStudentById(String id) {
        return repo.findById(id);
    }

    @Override
    public String removeStudent(String id) {
        Optional<Student> student = repo.findById(id);

        if (student.isEmpty()) return "Record Doesn't exist";

        repo.deleteById(id);

        return "Record Deleted";
    }

    @Override
    public List<Student> byName(String name) {
        
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("sas"));

        template.find(query, Student.class);

        return repo.findAllByNameEquals(name);
    }


}
