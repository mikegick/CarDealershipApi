package com.catalyte.dealership.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "You are not authorized to access this endpoint")
public class NotAuthorizedException extends RuntimeException {

}
