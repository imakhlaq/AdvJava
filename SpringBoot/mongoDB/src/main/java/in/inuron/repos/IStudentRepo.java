package in.inuron.repos;

import in.inuron.documents.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStudentRepo extends MongoRepository<Student, String> {
}
