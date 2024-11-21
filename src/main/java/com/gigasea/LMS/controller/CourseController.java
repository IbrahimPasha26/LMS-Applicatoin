package com.gigasea.LMS.controller;

import com.gigasea.LMS.model.Course;
import com.gigasea.LMS.repository.CourseRepository;
import com.gigasea.LMS.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/registerCourse")
    public String registerCourse(Model model){
        Course course = new Course();
        model.addAttribute("course",course);
        return "registerCourse";
    }
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course")Course course){
        courseService.saveCourse(course);
        return "redirect:/registerCourse";
    }
    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return "redirect:/adminPanel";
    }
    @GetMapping("/updateCourse/{id}")
    public String updateCourse(Model model, @PathVariable Long id){
        Course course = courseService.getCourseId(id);
        model.addAttribute("course",course);
        return "updateCourse";
    }
}
