package com.onetouch.exceptions;


import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OnetouchGlobalExceptionHandler {

	@ExceptionHandler({DataAccessException.class})
    public ResponseEntity<Error> handleGenericException1(Exception ex) {
        Error errorResponse = new Error();
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setErrorMessage("Duiplicate Mobile Number");
        return new ResponseEntity<Error>(errorResponse, HttpStatus.OK);
    }
	/*@ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(Exception ex) {
        Error errorResponse = new Error();
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setErrorMessage("There is some techncal issue");
        return new ResponseEntity<Error>(errorResponse, HttpStatus.OK);
    }
	*/
	
	
}
