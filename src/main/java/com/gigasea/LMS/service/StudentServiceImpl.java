package com.gigasea.LMS.service;

import com.gigasea.LMS.model.Course;
import com.gigasea.LMS.model.Student;
import com.gigasea.LMS.repository.CourseRepository;
import com.gigasea.LMS.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void saveStudent(Student student) {
    studentRepository.save(student);
    }

    @Override
    public List<Student> findStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentId(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
    studentRepository.deleteAll();
    }

    @Override
    public void addCourseToStudent(Long studentId, Long courseId) {
    Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student Not Found !!"));
    Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course Not Found !!"));
    student.getCourses().add(course);
    studentRepository.save(student);
    }
}
