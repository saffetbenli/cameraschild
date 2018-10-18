package be.kdg.processor.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class BoeteExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BoeteException.class})
    protected ResponseEntity<?> handleBoeteNotFound(RuntimeException ex, WebRequest request){
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND, request);
    }
}
