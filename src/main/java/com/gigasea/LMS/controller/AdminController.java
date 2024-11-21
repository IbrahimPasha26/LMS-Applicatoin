package com.gigasea.LMS.controller;

import com.gigasea.LMS.model.Course;
import com.gigasea.LMS.model.Student;
import com.gigasea.LMS.service.CourseService;
import com.gigasea.LMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @GetMapping("/adminPanel")
    public String adminPanel(Model model){
        List<Student> students = studentService.findStudents();
        List<Course> courses = courseService.findCourses();
        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        return "adminPanel";
    }
}