package com.softarex.domas.virtual_classroom.exception;

import static com.softarex.domas.virtual_classroom.exception.constant.MessageExceptionConstant.MESSAGE_STUDENT_NAME_IS_EXIST;

public class StudentExistException extends RuntimeException {

    public StudentExistException(String nameOfStudent) {
        super(nameOfStudent + MESSAGE_STUDENT_NAME_IS_EXIST);
    }

}
