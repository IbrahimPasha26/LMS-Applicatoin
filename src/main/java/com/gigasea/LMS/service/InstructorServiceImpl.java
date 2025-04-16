package com.gigasea.LMS.service;

import com.gigasea.LMS.model.Course;
import com.gigasea.LMS.model.Instructor;
import com.gigasea.LMS.repository.CourseRepository;
import com.gigasea.LMS.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorServiceImpl implements InstructorService{
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> findInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorId(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public void deleteAllInstructor() {
        instructorRepository.deleteAll();
    }

    @Override
    public void addCourseToInstructor(Long instructorId, Long courseId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new RuntimeException("Instructor Not Found !!"));
        Course course = courseRepository.findById(courseId).orElseThrow(()-> new RuntimeException("Course not Found !!"));
        instructor.getCourses().add(course);
        instructorRepository.save(instructor);
    }
}
