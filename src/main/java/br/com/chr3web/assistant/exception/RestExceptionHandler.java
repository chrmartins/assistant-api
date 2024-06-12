package br.com.chr3web.assistant.exception;

import br.com.chr3web.assistant.modules.user.exceptions.UserAlreadyExistsException;
import br.com.chr3web.assistant.modules.user.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    protected ResponseEntity<Object> handleUserAlreadyExists(UserAlreadyExistsException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, ex.getMessage(), ex);
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}