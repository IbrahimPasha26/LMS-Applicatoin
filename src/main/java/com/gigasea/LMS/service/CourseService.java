package com.gigasea.LMS.service;

import com.gigasea.LMS.model.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);
    List<Course> findCourses();
    Course getCourseId(Long id);
    void deleteCourse(Long id);
    void deleteALlCourses();
}
