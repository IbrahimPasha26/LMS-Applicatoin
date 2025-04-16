package com.gigasea.LMS.service;

import com.gigasea.LMS.model.Instructor;

import java.util.List;

public interface InstructorService {
    void saveInstructor(Instructor instructor);
    List<Instructor> findInstructors();
    Instructor getInstructorId(Long id);
    void deleteInstructor(Long id);
    void deleteAllInstructor();
    void addCourseToInstructor(Long instructorId, Long courseId);
}
