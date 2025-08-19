package com.eduardo.library_system.controllers;

import com.eduardo.library_system.dtos.student.StudentResponse;
import com.eduardo.library_system.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Page<StudentResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(studentService.findAll(pageable));
    }

}
