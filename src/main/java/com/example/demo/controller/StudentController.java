package com.example.demo.controller;

import com.example.demo.data.StudentData;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/result")
    public String show(Model model){
        model.addAttribute("result", studentService.findAll());
        return "resultPage";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("studentData", new StudentData());
        return "addHomePage";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("studentData") StudentData studentData){
        studentService.create(studentData);
        return "redirect:/result";
    }

    @GetMapping("/deleteHome")
    public String deleteHome(Model model) {

        List<Student> list = studentService.findAll();
        StringBuilder str = new StringBuilder();
        for (Student student : list) {
            str.append(student.getId()).append(" ");
        }

        model.addAttribute("allId", str);
        return "deleteHomePage";
    }

    @PostMapping("/delete")
    public String delete(Long id){
        List<Student> list = studentService.findAll();
        if (list.stream().anyMatch(student -> student.getId().equals(id))) {
            studentService.deleteById(id);
        } else {
            System.out.println("does not exist this id");
        }

        return "redirect:/result";
    }

    @PostMapping("/deleteAll")
    public String deleteAll(){
        studentService.delete();
        return "redirect:/result";
    }
}
