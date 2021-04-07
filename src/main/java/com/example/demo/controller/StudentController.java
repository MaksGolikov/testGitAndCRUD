package com.example.demo.controller;

import com.example.demo.data.StudentData;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/result")
    public String show(Model model){
        model.addAttribute("result", studentService.findAll());
        return "result";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("studentData", new StudentData());
        return "home";
    }

    @PostMapping()
    public String create(@ModelAttribute("studentData") StudentData studentData){
        studentService.create(studentData);
        return "redirect:/result";
    }
}
