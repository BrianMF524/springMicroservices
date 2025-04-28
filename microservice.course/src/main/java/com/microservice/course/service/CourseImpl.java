package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.course.persistence.ICourseRepo;

import java.util.List;

@Service
public class CourseImpl implements ICourseService{
    @Autowired
    private ICourseRepo courseRepo;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepo.findAll();
    }

    @Override
    public Course findById(Long idCourse) {
        return courseRepo.findById(idCourse).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepo.save(course);
    }

    @Override
    public StudentsByCourseResponse findAllStudentsByIdCourse(Long idCourse) {

        Course course=courseRepo.findById(idCourse).orElseThrow();

        List<StudentDTO> studentDTOList = studentClient.findAllStudentsByCourse(course.getId());
        return StudentsByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentsDTOList(studentDTOList)
                .build();
    }
}
