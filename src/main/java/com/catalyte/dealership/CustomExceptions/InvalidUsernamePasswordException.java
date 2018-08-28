package com.catalyte.dealership.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Invalid username and/or password")
public class InvalidUsernamePasswordException extends RuntimeException {

}