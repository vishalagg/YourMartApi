package com.nagarro.yourmartapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="There is an error in server, Please try again later")
public class ServerSideException extends RuntimeException{

}
