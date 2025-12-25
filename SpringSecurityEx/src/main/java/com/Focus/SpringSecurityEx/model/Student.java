package com.Focus.SpringSecurityEx.model;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    @RestController
    public static class StudentController {

        private List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Joey",70),
                new Student(2,"Rachel",40),
                new Student(3,"Chandler",30)
        ));
        @GetMapping("/students")
        public List<Student> getstudents(){
            return students;
        }

        @PostMapping("/students")
        public Student addStudent(@RequestBody Student stud){
             students.add(stud);
             return stud;
        }

        @GetMapping("/csrf-token")
        public CsrfToken getCerfToken(HttpServletRequest request){
            return (CsrfToken) request.getAttribute("_csrf"); //getAttribute gives type of obj so typecasted
        }
    }
}

