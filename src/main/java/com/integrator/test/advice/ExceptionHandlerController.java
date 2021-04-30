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

import java.util.UUID;

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
    public ResponseEntity<ErrorView> wrongInput(WrongInputException wrongInputException){
        String ex = wrongInputException.getMessage();
        ErrorView errorView = new ErrorView(ex);
        return new ResponseEntity<>(errorView, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorView> collapse(){
        String[] tempCode = UUID.randomUUID().toString().split("-");
        String errorCode = tempCode[0];
        ErrorView errorView = new ErrorView("Произошла ошибка с кодом " + errorCode + " мы уже работаем над ее исправлением");
        return new ResponseEntity<>(errorView, HttpStatus.BAD_REQUEST);
    }

}
