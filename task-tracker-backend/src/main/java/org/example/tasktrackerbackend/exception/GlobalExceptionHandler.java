package org.example.tasktrackerbackend.exception;


import java.io.Serial;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorLogs> handleAPIException(Exception exception,
      WebRequest webRequest){

    ErrorLogs errorDetails = new ErrorLogs(
        LocalDateTime.now(),
        exception.getMessage(),
        webRequest.getDescription(false)
    );

    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public static class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
      super(message);
    }
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public static class UserExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserExistsException(String message) {
      super(message);
    }
  }

  public static class UserUnauthorizedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserUnauthorizedException(String message) {
      super(message);
    }
  }
}
