package com.onetouch.exceptions;


import java.net.SocketTimeoutException;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OnetouchGlobalExceptionHandler {
	@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> handleGenericException3(Exception ex) {
        Error errorResponse = new Error();
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setErrorMessage("DuplicateMobileNumber");
        return new ResponseEntity<Error>(errorResponse, HttpStatus.OK);
    }

	@ExceptionHandler({DataAccessException.class,SQLException.class})
    public ResponseEntity<Error> handleGenericException1(Exception ex) {
        Error errorResponse = new Error();
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setErrorMessage("DbException");
        return new ResponseEntity<Error>(errorResponse, HttpStatus.OK);
    }
	@ExceptionHandler(SocketTimeoutException.class)
    public ResponseEntity<Error> handleGenericException(Exception ex) {
        Error errorResponse = new Error();
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setErrorMessage("TechnicalIssuewithMsg91");
        return new ResponseEntity<Error>(errorResponse, HttpStatus.OK);
    }
	
	
	
}
