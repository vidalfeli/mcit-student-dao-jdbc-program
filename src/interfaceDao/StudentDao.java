package interfaceDao;

import java.util.List;
import model.Student;

public interface StudentDao {

    void create(Student s);

    void update(Student s);

    void delete(int id);

    List<Student> findAll();

    Student findById(int id);

}
