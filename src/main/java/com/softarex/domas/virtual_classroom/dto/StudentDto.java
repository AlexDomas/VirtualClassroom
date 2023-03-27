package com.softarex.domas.virtual_classroom.dto;

import com.softarex.domas.virtual_classroom.dto.validator.group.OnCreate;
import com.softarex.domas.virtual_classroom.dto.validator.group.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

import static com.softarex.domas.virtual_classroom.dto.validator.constant.MessageErrorStudentDTOConstant.*;
import static com.softarex.domas.virtual_classroom.dto.validator.regexp.RegularExpressionForStudentName.REGULAR_EXPRESSION_FOR_STUDENT_NAME;

@Getter
@Setter
@AllArgsConstructor
public class StudentDto {

    @Null(groups = OnCreate.class, message = MESSAGE_STUDENT_ID_IS_NULL)
    @NotNull(groups = OnUpdate.class, message = MESSAGE_STUDENT_ID_IS_NOT_NULL)
    private UUID id;

    @Size(min = MIN_LENGTH_STUDENT_NAME, max = MAX_LENGTH_STUDENT_NAME, message = MESSAGE_STUDENT_NAME_LENGTH)
    @Pattern(regexp = REGULAR_EXPRESSION_FOR_STUDENT_NAME, message = MESSAGE_STUDENT_NAME_REGULAR_EXPRESSION)
    @NotNull(message = MESSAGE_STUDENT_NAME_IS_NULL)
    private String name;

    private boolean hand;

}
