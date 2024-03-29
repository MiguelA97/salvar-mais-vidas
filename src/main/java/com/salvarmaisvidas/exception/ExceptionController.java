package com.salvarmaisvidas.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionController.class);

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value= { GeneralException.class})
    protected ResponseEntity<Map<String, String>> handleConflict(GeneralException ex, WebRequest request) {
        String message = messageSource.getMessage(ex.getErrorMessage(), ex.getExceptionId(), LocaleContextHolder.getLocale());
        return new ResponseEntity<>( Map.of("message",message), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value= { Exception.class})
    protected ResponseEntity<Map<String, String>> handleConflict(Exception ex, WebRequest request) {
        LOG.error("Unexpected Error", ex);
        return new ResponseEntity<>( Map.of("message","Contact the application support"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}