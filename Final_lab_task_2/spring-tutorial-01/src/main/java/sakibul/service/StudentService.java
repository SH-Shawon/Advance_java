package sakibul.service;
import org.springframework.stereotype.Service;
import sakibul.domain.Student;
import sakibul.repository.StudentRepository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void addStudent(Student student) throws SQLException {
        studentRepository.addStudent(student);
    }

    public List<Student> getAllStudent() throws SQLException {

        return studentRepository.getAll();
    }

    public Student getStudentById(int studentId) throws SQLException {
        return studentRepository.getStudentById(studentId);
    }

    public void deleteStudentById(int studentId) throws SQLException {
        studentRepository.deleteStudentById(studentId);
    }

    public boolean delete(int id) throws SQLException {
        return studentRepository.delete(id);
    }

    public void updateStudent(int studentId, Student updatedStudent) throws SQLException {
        System.out.println("I am service");
        studentRepository.updateStudent(studentId, updatedStudent);
    }

//    public void update(Student student) throws  SQLException {
//        if(getStudentById(student.getId())!=null){
//            studentRepository.update(student);
//        }
//    }
}
