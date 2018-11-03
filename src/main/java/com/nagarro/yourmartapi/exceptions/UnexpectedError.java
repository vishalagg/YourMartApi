package com.nagarro.yourmartapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason ="Unexpected Error occur")
public class UnexpectedError extends RuntimeException{

}
