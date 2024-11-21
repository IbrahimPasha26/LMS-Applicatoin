package com.gigasea.LMS.controller;

import com.gigasea.LMS.model.Course;
import com.gigasea.LMS.model.Student;
import com.gigasea.LMS.repository.CourseRepository;
import com.gigasea.LMS.repository.StudentRepository;
import com.gigasea.LMS.service.CourseService;
import com.gigasea.LMS.service.StudentService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @GetMapping("/registerStudent")
    public String resisterStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "registerStudent";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student);
        return "redirect:/registerStudent";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/adminPanel";
    }
    @GetMapping("/assignCourseToStudent")
    public String assignCourseToStudent(Model model){
        List<Course> courses = courseService.findCourses();
        model.addAttribute("courses", courses);
        return "assignCourseToStudent";
    }
    @PostMapping("/addCourseToStudent")
    public String addCourseToStudent(@RequestParam Long studentId, @RequestParam Long courseId){
        studentService.addCourseToStudent(studentId,courseId);
        return "redirect:/adminPanel";
    }
        @GetMapping("/updateStudent/{id}")
    public String updateStudent(Model model, @PathVariable Long id){
        Student student = studentService.getStudentId(id);
        model.addAttribute("student", student);
        return "updateStudent";
    }
    @GetMapping("/studentWithCourse")
    public String studentWithCourse(Model model){
        List<Student> students = studentService.findStudents();
        model.addAttribute("students",students);
        return "studentWithCourse";
    }
    @GetMapping("/studentHome")//Incomplete
    public String studentHome(Model model){
        List<Student> students = studentService.findStudents();
        model.addAttribute("students", students);
        return "studentHome";
    }
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
}
