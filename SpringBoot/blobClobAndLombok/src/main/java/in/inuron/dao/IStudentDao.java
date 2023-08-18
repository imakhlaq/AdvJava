package in.inuron.dao;

import in.inuron.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IStudentDao extends CrudRepository<Student, UUID> {
}
