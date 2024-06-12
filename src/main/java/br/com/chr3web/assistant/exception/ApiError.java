package br.com.chr3web.assistant.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiError {
    private HttpStatus status;
    private String message;
    private String debugMessage;

    public ApiError(HttpStatus status, String message, Throwable ex) {
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}