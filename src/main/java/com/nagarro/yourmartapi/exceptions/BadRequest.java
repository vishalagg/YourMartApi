package com.nagarro.yourmartapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="check the inputs")
public class BadRequest extends RuntimeException{

}
