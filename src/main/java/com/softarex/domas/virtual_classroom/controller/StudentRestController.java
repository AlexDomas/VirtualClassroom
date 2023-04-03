package com.softarex.domas.virtual_classroom.controller;

import com.softarex.domas.virtual_classroom.dto.StudentDto;
import com.softarex.domas.virtual_classroom.dto.validator.group.OnCreate;
import com.softarex.domas.virtual_classroom.dto.validator.group.OnUpdate;
import com.softarex.domas.virtual_classroom.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import static com.softarex.domas.virtual_classroom.dto.validator.constant.MessageErrorStudentDTOConstant.MESSAGE_STUDENT_ID_IS_NULL;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public StudentDto getStudentById(@PathVariable("studentId")
                                     @NotNull(message = MESSAGE_STUDENT_ID_IS_NULL) UUID uuid) {
        return studentService.getById(uuid);
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAll();
    }

    @PutMapping("/{studentId}")
    @Validated(value = {OnUpdate.class})
    public StudentDto updateStudentData(@PathVariable("studentId")
                                            @NotNull(message = MESSAGE_STUDENT_ID_IS_NULL) UUID id,
                                        @RequestBody @Valid StudentDto studentDto) {
        return studentService.update(id, studentDto);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable("studentId")
                                  @NotNull(message = MESSAGE_STUDENT_ID_IS_NULL) UUID id) {
        studentService.deleteById(id);
    }

    @PostMapping
    @Validated(value = {OnCreate.class})
    public StudentDto create(@RequestBody @Valid StudentDto studentDto) {
        return studentService.create(studentDto);
    }

}
