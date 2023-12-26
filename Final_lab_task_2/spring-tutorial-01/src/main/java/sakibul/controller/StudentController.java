package sakibul.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sakibul.domain.Quota;
import sakibul.domain.Student;
import sakibul.service.StudentService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @InitBinder
    public void initbinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @RequestMapping("/addStudent")
    public String newStudent(Model model) {
        List<Quota> quotaOptions = new ArrayList<>();
        quotaOptions.add(Quota.A);
        quotaOptions.add(Quota.B);
        System.out.println("Quota Options Size: " + quotaOptions.size());
        System.out.println(quotaOptions);



        model.addAttribute("quotaOptions", quotaOptions);
        model.addAttribute("student", new Student());

        return "studentForm";
    }

     @RequestMapping("/students")
     public String save(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) throws SQLException {
        if(bindingResult.hasErrors()){
            List<Quota> quotaOptions = new ArrayList<>();
            quotaOptions.add(Quota.A);
            quotaOptions.add(Quota.B);
            model.addAttribute("quotaOptions", quotaOptions);
            return "studentForm";
        } else {
            //In this line I add the new student
            studentService.addStudent(student);

            //Here, after adding a new student I show all the student along with the new one
            try {
                List<Student> students = studentService.getAllStudent();
                model.addAttribute("students", students);
                return "allStudent";
            } catch (SQLException e) {
                e.printStackTrace();
                return "error";
            }
        }
    }

    //This on is for showing all student too.
    @RequestMapping("/allStudent")
    public String showAllStudent(Model model) {
        try {

            List<Student> students = studentService.getAllStudent();
            model.addAttribute("students", students);
            return "allStudent";
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/students/{studentId}/details")
    public String showStudentDetails(@PathVariable int studentId, Model model) {
        try {
            Student student = studentService.getStudentById(studentId);

            model.addAttribute("student", student);

            return "studentDetails";
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable int studentId) {
        try {
            studentService.deleteStudentById(studentId);

            return "redirect:/allStudent";
        } catch (SQLException e) {

            e.printStackTrace();
            return "error";
        }
    }


    @RequestMapping("/students/{studentId}/edit")
    public String showEditForm(@PathVariable int studentId, Model model) {
        try {
            Student student = studentService.getStudentById(studentId);

            model.addAttribute("student", student);


            return "editStudent";
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping("/students/{studentId}/update")
    public String updateStudent(@PathVariable int studentId, @Valid @ModelAttribute("student") Student updatedStudent, BindingResult bindingResult) {
        System.out.println("Binding Result Errors: " + bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {
            return "editStudent";
        }

        try {
            Student existingStudent = studentService.getStudentById(studentId);

            // Don't want to update gender field. that is why this 3 only.
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());

            studentService.updateStudent(studentId, existingStudent);

            return "redirect:/students/" + studentId + "/details";
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }





}
