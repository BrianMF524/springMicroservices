package com.microservice.course.service;

import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;

import java.util.List;


public interface ICourseService {
    List<Course> findAll();
    Course findById(Long idCourse);
    void save(Course course);
    StudentsByCourseResponse findAllStudentsByIdCourse(Long idCourse);
}
