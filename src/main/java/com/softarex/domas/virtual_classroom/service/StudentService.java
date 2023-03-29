package com.softarex.domas.virtual_classroom.service;

import com.softarex.domas.virtual_classroom.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<StudentDto> getAll();

    StudentDto getById(UUID id);

    void deleteById(UUID id);

    StudentDto create(StudentDto studentDto);

}
