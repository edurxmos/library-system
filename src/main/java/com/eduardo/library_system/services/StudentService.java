package com.eduardo.library_system.services;

import com.eduardo.library_system.dtos.student.StudentRequest;
import com.eduardo.library_system.dtos.student.StudentResponse;
import com.eduardo.library_system.entities.Student;
import com.eduardo.library_system.mappers.StudentMapper;
import com.eduardo.library_system.repositories.StudentRepository;
import com.eduardo.library_system.services.exceptions.DataBaseException;
import com.eduardo.library_system.services.exceptions.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Transactional(readOnly = true)
    public Page<StudentResponse> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable).map(x -> studentMapper.toResponse(x));
    }

    @Transactional(readOnly = true)
    public StudentResponse findById(Long id) {
        return studentRepository.findById(id).map(x -> studentMapper.toResponse(x))
                .orElseThrow(() -> new NotFoundException("Resource not found"));
    }

    @Transactional
    public StudentResponse insert(StudentRequest request) {
        Student entity = studentRepository.save(studentMapper.toEntity(request));
        return studentMapper.toResponse(entity);
    }

    @Transactional
    public StudentResponse update(Long id, StudentRequest request) {
        Student entity = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Resource not found"));
        studentMapper.updateEntity(request, entity);
        entity = studentRepository.save(entity);
        return studentMapper.toResponse(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            if (studentRepository.existsById(id)) {
                studentRepository.deleteById(id);
            } else {
                throw new NotFoundException("Resource not found");
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Relational integrity violation");
        }
    }

}
