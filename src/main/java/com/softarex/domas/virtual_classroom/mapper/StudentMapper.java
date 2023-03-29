package com.softarex.domas.virtual_classroom.mapper;

import com.softarex.domas.virtual_classroom.dto.StudentDto;
import com.softarex.domas.virtual_classroom.entity.student.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    public Student toStudentEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setHand(studentDto.isHand());
        return student;
    }

    public StudentDto toStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setHand(student.isHand());
        return studentDto;
    }

    public List<StudentDto> toStudentDtoList(List<Student> listOfStudentEntities) {
        List<StudentDto> listOfStudentDto = new ArrayList<>(listOfStudentEntities.size());
        listOfStudentEntities.forEach(student -> listOfStudentDto.add(toStudentDto(student)));
        return listOfStudentDto;
    }

    public Student update(Student student, StudentDto studentDto) {
        student.setName(studentDto.getName());
        student.setHand(studentDto.isHand());
        return student;
    }

}
