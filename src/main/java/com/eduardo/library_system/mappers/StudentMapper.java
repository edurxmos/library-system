package com.eduardo.library_system.mappers;

import com.eduardo.library_system.dtos.student.StudentRequest;
import com.eduardo.library_system.dtos.student.StudentResponse;
import com.eduardo.library_system.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request) {
        Student entity = new Student();
        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setGrade(request.grade());
        entity.setClassroom(request.classroom());
        return entity;
    }

    public StudentResponse toResponse(Student entity) {
        return new StudentResponse(entity.getId(), entity.getName(), entity.getEmail(),
                entity.getGrade(), entity.getClassroom());
    }

}
