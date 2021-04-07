package com.example.demo.service.impl;

import com.example.demo.data.StudentData;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(StudentData studentData) {
        Student student = new Student();
        student.setFirstName(studentData.getFirstName());
        student.setLastName(studentData.getLastName());
        student.setAge(studentData.getAge());
        studentRepository.save(student);
    }

    @Override
    public void update(StudentData studentData, Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setFirstName(studentData.getFirstName());
        student.setLastName(studentData.getLastName());
        studentRepository.save(student);
    }

    @Override
    public void delete() {
        studentRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
