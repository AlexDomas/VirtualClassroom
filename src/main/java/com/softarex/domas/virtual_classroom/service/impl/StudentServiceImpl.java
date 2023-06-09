package com.softarex.domas.virtual_classroom.service.impl;

import com.softarex.domas.virtual_classroom.dto.StudentDto;
import com.softarex.domas.virtual_classroom.entity.student.Student;
import com.softarex.domas.virtual_classroom.exception.StudentExistException;
import com.softarex.domas.virtual_classroom.exception.StudentNotFoundException;
import com.softarex.domas.virtual_classroom.mapper.StudentMapper;
import com.softarex.domas.virtual_classroom.repository.StudentRepository;
import com.softarex.domas.virtual_classroom.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.softarex.domas.virtual_classroom.exception.constant.MessageExceptionConstant.MESSAGE_STUDENT_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    private final SimpMessagingTemplate simpMessagingTemplate;

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
    public StudentDto update(UUID id, StudentDto studentDto) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new StudentNotFoundException(MESSAGE_STUDENT_NOT_FOUND_BY_ID));

        Student newStudent = studentMapper.update(student, studentDto);
        studentRepository.save(newStudent);

        simpMessagingTemplate.convertAndSend("/topic/members/update", student);

        return studentMapper.toStudentDto(student);
    }

    @Override
    public void deleteById(UUID id) {
        studentRepository.deleteById(id);
        simpMessagingTemplate.convertAndSend("/topic/members/delete", id);
    }

    @Override
    public StudentDto create(StudentDto studentDto) {
        if(studentRepository.existsByName(studentDto.getName())){
            throw new StudentExistException(studentDto.getName());
        }
        Student student = studentMapper.toStudentEntity(studentDto);
        Student saveStudent = studentRepository.save(student);
        simpMessagingTemplate.convertAndSend("/topic/members/create", saveStudent);
        return studentMapper.toStudentDto(saveStudent);
    }

}
