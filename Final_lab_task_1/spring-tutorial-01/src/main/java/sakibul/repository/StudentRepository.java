package sakibul.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import sakibul.domain.Student;

import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {
    private SessionFactory sessionFactory;

    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addStudent(Student student) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }
    
    public List<Student> getAll() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> studentQuery = session.createQuery("FROM Student", Student.class);
        System.out.println(studentQuery);
        return studentQuery.getResultList();
    }

    public Student getStudentById(int studentId) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, studentId);
    }

    public void deleteStudentById(int studentId) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studentId);
        if (student != null) {
            session.delete(student);
        }
    }

    public void updateStudent(int studentId, Student updatedStudent) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Student existingStudent = session.get(Student.class, studentId);

        System.out.println("I am repository");
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());

        session.update(existingStudent);
    }

}
