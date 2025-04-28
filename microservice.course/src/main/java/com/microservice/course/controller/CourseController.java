package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microservice.course.service.ICourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveCourse(@RequestBody Course c){
        courseService.save(c);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourses(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse){
        System.out.println(courseService.findAllStudentsByIdCourse(idCourse));
        return ResponseEntity.ok(courseService.findAllStudentsByIdCourse(idCourse));
    }
}
