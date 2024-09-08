package com.example.cinema_back_end.security.exceptions;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    USER_EXISTED(10001,"User existed"),
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized exception"),
    USER_NOT_EXISTED(10004,"User not existed"),
    Movie_NOT_EXISTED(10005,"Moive not existed"),
    Brand_NOT_EXISTED(10006,"Brand not existed"),
    Room_NOT_EXISTED(10007,"Room not existed"),
    UNAUTHENTICATED_EXCEPTION(10006,"Unauthenticated exception"),
    MIX_FIELD_FEEDBACK(10006,"You add mix field feedbach"),
    ROLE_NOT_FOUND(10007,"Role not found"),
    CODE_ALREADY_EXISTS(10008,"Code already exists"),
    ;
    int code;
    String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
