package com.eduardo.library_system.services;

import com.eduardo.library_system.dtos.student.StudentRequest;
import com.eduardo.library_system.dtos.student.StudentResponse;
import com.eduardo.library_system.entities.Student;
import com.eduardo.library_system.mappers.StudentMapper;
import com.eduardo.library_system.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public Page<StudentResponse> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable).map(x -> studentMapper.toResponse(x));
    }

    public StudentResponse findById(Long id) {
        return studentRepository.findById(id).map(x -> studentMapper.toResponse(x))
                .orElseThrow(() -> new RuntimeException("Resource not found"));
    }

    public StudentResponse insert(StudentRequest request) {
        Student entity = studentRepository.save(studentMapper.toEntity(request));
        return studentMapper.toResponse(entity);
    }

    public StudentResponse update(Long id, StudentRequest request) {
        Student entity = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found"));
        studentMapper.updateEntity(request, entity);
        entity = studentRepository.save(entity);
        return studentMapper.toResponse(entity);
    }

    public void delete(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

}
