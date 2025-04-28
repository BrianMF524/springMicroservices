package com.microservice.student.service;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Student> findByCourseId(Long courseId) {
        return studentRepo.findAllByCourseId(courseId);
    }
}
