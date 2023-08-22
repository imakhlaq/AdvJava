package in.inuron.repos;

import in.inuron.documents.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface IStudentRepo extends MongoRepository<Student, String> {
    List<Student> findAllByNameEquals(String name);
}
