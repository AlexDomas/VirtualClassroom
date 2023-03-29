package com.softarex.domas.virtual_classroom.dto.validator.constant;

public interface MessageErrorStudentDTOConstant {

    int MIN_LENGTH_STUDENT_NAME = 3;

    int MAX_LENGTH_STUDENT_NAME = 20;

    String MESSAGE_STUDENT_NAME_IS_NULL = "Student name cannot be null";

    String MESSAGE_STUDENT_NAME_LENGTH = "Student name length must be between ( " + MIN_LENGTH_STUDENT_NAME + ", " + MAX_LENGTH_STUDENT_NAME + " )";

    String MESSAGE_STUDENT_NAME_REGULAR_EXPRESSION = "Student name must contain only english letters";

    String MESSAGE_STUDENT_ID_IS_NULL = "The unique identifier must be specified";

    String MESSAGE_STUDENT_ID_IS_NOT_NULL = "The unique identifier must not be specified";

}
