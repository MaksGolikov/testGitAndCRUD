package com.example.demo.service;

import com.example.demo.data.StudentData;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import java.util.List;

public interface StudentService {
    void create(StudentData studentData);
    void update(StudentData studentData, Long id);
    void delete();
    void deleteById(Long id);
    List<Student> findAll();
}
