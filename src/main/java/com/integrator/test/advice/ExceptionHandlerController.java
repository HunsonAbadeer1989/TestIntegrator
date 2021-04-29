package com.integrator.test.advice;

import com.integrator.test.exception.OfficeException;
import com.integrator.test.exception.OrganizationException;
import com.integrator.test.exception.UserException;
import com.integrator.test.exception.WrongInputException;
import com.integrator.test.office.view.ErrorView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(OfficeException.class)
    public ResponseEntity<ErrorView> officeException(OfficeException officeException){
        String ex = officeException.getMessage();
        ErrorView errorView = new ErrorView(ex);
        return new ResponseEntity<>(errorView, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrganizationException.class)
    public ResponseEntity<ErrorView> orgException(OrganizationException organizationException){
        String ex = organizationException.getMessage();
        ErrorView errorView = new ErrorView(ex);
        return new ResponseEntity<>(errorView, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorView> userException(UserException userException){
        String ex = userException.getMessage();
        ErrorView errorView = new ErrorView(ex);
        return new ResponseEntity<>(errorView, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongInputException.class)
    public ResponseEntity<ErrorView> wrongInput(WrongInputException userException){
        String ex = userException.getMessage();
        ErrorView errorView = new ErrorView(ex);
        return new ResponseEntity<>(errorView, HttpStatus.BAD_REQUEST);
    }

}
