package sakibul.rest;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sakibul.domain.Student;
import sakibul.service.StudentService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/users")
    public List<Student> getStudents() throws SQLException {
        return studentService.getAllStudent();
    }

    @GetMapping("/users/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) throws SQLException {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return studentService.getStudentById(id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/users/{id}")
    public String deleteStudent(@PathVariable("id") int id) throws SQLException {
        if (studentService.delete(id)) {
            return "Successful";
        } else {
            return "Unsuccessful";
        }
    }

    @GetMapping("/users/count")
    public String getStudentCount() throws SQLException {
        return String.valueOf((long) studentService.getAllStudent().size());
    }

    @PostMapping("/users")
    public String createStudent(@Valid @RequestBody Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "Unsuccessful";
        } else {
            studentService.addStudent(student);
            return "Successful";
        }
    }

    @PutMapping("/users/{studentId}")
    public String updateStudent(@PathVariable int studentId, @Valid @ModelAttribute("student") Student updatedStudent, BindingResult bindingResult) {
        System.out.println("Binding Result Errors: " + bindingResult.getAllErrors());
        if (bindingResult.hasErrors()) {
            return "Unsuccessful";
        }
        try {
            Student existingStudent = studentService.getStudentById(studentId);

            // Don't want to update gender field. that is why this 3 only.
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());

            studentService.updateStudent(studentId, existingStudent);

        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
        return "successful";
    }
}
