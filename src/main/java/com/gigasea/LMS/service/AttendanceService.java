package com.gigasea.LMS.service;

import com.gigasea.LMS.model.Attendance;

import java.util.List;

public interface AttendanceService {
    void saveAttendance(Attendance attendance);
    List<Attendance> findAttendance();
    Attendance getAttendanceId(Long id);
    void deleteAttendance(Long id);
    void deleteAllAttendance();
}
