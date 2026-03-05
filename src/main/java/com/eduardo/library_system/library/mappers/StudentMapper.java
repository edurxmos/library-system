package com.eduardo.library_system.library.mappers;

import com.eduardo.library_system.library.dtos.student.StudentRequest;
import com.eduardo.library_system.library.dtos.student.StudentResponse;
import com.eduardo.library_system.library.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request) {
        return new Student(request.name(), request.email(), request.grade(), request.classroom());
    }

    public StudentResponse toResponse(Student entity) {
        return new StudentResponse(entity.getId(), entity.getName(), entity.getEmail(),
                entity.getGrade(), entity.getClassroom());
    }

    public Student updateEntity(StudentRequest request, Student entity) {
        entity.update(request.name(), request.email(), request.grade(), request.classroom());
        return entity;
    }

}
