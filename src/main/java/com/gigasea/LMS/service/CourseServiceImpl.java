package com.gigasea.LMS.service;

import com.gigasea.LMS.model.Course;
import com.gigasea.LMS.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> findCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseId(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void deleteALlCourses() {
    courseRepository.deleteAll();
    }
}
