package com.nagarro.yourmartapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason = "You are authorized to access/change")
public class UnAuthorizedException extends RuntimeException{

}
