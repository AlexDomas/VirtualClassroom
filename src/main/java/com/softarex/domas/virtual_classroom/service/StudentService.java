package com.softarex.domas.virtual_classroom.service;

import com.softarex.domas.virtual_classroom.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    StudentDto create(StudentDto studentDto);

    List<StudentDto> getAll();

    StudentDto getById(UUID id);

    StudentDto update(StudentDto studentDto);

    void deleteById(UUID id);

}
