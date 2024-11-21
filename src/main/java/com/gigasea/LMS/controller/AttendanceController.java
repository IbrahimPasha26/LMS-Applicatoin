package com.gigasea.LMS.controller;

import com.gigasea.LMS.model.Attendance;
import com.gigasea.LMS.model.Student;
import com.gigasea.LMS.service.AttendanceService;
import com.gigasea.LMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private StudentService studentService;
    @GetMapping("/attendance/mark")
    public String markAttendance(Model model){
        Attendance attendance = new Attendance();
        model.addAttribute("attendance", attendance);
        return "markAttendance";
    }
    @PostMapping("/attendance/save")
    public String saveAttendance(@ModelAttribute Attendance attendance){
        attendanceService.saveAttendance(attendance);
        return "redirect:/attendance/view";
    }
    @GetMapping("/attendance/view")
    public String viewAttendance(Model model){
        List<Student> students = studentService.findStudents();
        Map<Long, String> studentNames = students.stream()
                .collect(Collectors.toMap(
                        Student::getId,
                        student ->student.getFirstName()+" "+student.getLastName()
                ));
        List<Attendance> attendances = attendanceService.findAttendance();
        attendances.forEach(attendance -> attendance.setStudentName(studentNames.get(attendance.getStudentId())));
        model.addAttribute("attendances", attendances);
        return "viewAttendance";
    }
}
