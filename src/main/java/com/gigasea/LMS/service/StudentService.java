package com.gigasea.LMS.service;

import com.gigasea.LMS.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> findStudents();
    Student getStudentId(Long id);
    void deleteStudent(Long id);
    void deleteAllStudents();
    void addCourseToStudent(Long studentId, Long courseId);
}
