package com.softarex.domas.virtual_classroom.service.impl;

import com.softarex.domas.virtual_classroom.dto.StudentDto;
import com.softarex.domas.virtual_classroom.entity.student.Student;
import com.softarex.domas.virtual_classroom.exception.StudentExistException;
import com.softarex.domas.virtual_classroom.exception.StudentNotFoundException;
import com.softarex.domas.virtual_classroom.mapper.StudentMapper;
import com.softarex.domas.virtual_classroom.repository.StudentRepository;
import com.softarex.domas.virtual_classroom.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.softarex.domas.virtual_classroom.exception.constant.MessageExceptionConstant.*;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    private StudentMapper studentMapper;

    @Override
    public List<StudentDto> getAll() {
        return studentMapper.toStudentDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDto getById(UUID id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(MESSAGE_STUDENT_NOT_FOUND_BY_ID));
        return studentMapper.toStudentDto(student);
    }

    @Override
    public StudentDto create(StudentDto studentDto) {
        if(studentRepository.existsByName(studentDto.getName())){
            throw new StudentExistException(studentDto.getName());
        }
        Student student = studentMapper.toStudentEntity(studentDto);
        Student saveStudent = studentRepository.save(student);
        return studentMapper.toStudentDto(saveStudent);
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

}
