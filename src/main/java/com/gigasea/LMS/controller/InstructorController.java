package com.gigasea.LMS.controller;

import com.gigasea.LMS.model.Course;
import com.gigasea.LMS.model.Instructor;
import com.gigasea.LMS.model.Student;
import com.gigasea.LMS.service.CourseService;
import com.gigasea.LMS.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InstructorController {
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private CourseService courseService;
    @GetMapping("/registerInstructor")
    public String registerInstructor(Model model){
        Instructor instructor =  new Instructor();
        model.addAttribute("instructor", instructor);
        return "registerInstructor";
    }
    @PostMapping("/saveInstructor")
    public String saveInstructor(@ModelAttribute("instructor") Instructor instructor){
        instructorService.saveInstructor(instructor);
        return "redirect:/adminPanel";
    }
    @GetMapping("/updateInstructor/{id}")
    public String updateInstructor(Model model, @PathVariable Long id){
        Instructor instructor = instructorService.getInstructorId(id);
        model.addAttribute("instructor",instructor);
        return "updateInstructor";
    }
    @GetMapping("/deleteInstructor/{id}")
    public String deleteInstructor(@PathVariable Long id){
        instructorService.deleteInstructor(id);
        return "redirect:/adminPanel";
    }
    @GetMapping("/assignCourseToInstructor")
    public String assignCourseToInstructor(Model model){
        List<Course> courses = courseService.findCourses();
        model.addAttribute("courses",courses);
        return "assignCourseToInstructor";
    }
    @PostMapping("addCourseToInstructor")
    public String addCourseToInstructor(@RequestParam Long instructorId, @RequestParam Long courseId){
        instructorService.addCourseToInstructor(instructorId,courseId);
        return "redirect:/adminPanel";
    }
    @GetMapping("/instructorWithCourse")
    public String instructorWithCourse(Model model){
        List<Instructor> instructors = instructorService.findInstructors();
        model.addAttribute("instructors", instructors);
        return "instructorWithCourse";
    }
}
