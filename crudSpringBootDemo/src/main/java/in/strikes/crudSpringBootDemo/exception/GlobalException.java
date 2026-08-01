package in.strikes.crudSpringBootDemo.exception;

import in.strikes.crudSpringBootDemo.dto.ExceptionResponseDto;
import in.strikes.crudSpringBootDemo.dto.ValidationExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleResourceNotFoundException(
            ResourceNotFoundException ex,
            HttpServletRequest request) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(buildResponse(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage(),
                        request));
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDto> handleDuplicateResourceException(
            DuplicateResourceException ex,
            HttpServletRequest request) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(buildResponse(
                        HttpStatus.CONFLICT,
                        ex.getMessage(),
                        request));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGenericException(
            Exception ex,
            HttpServletRequest request) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buildResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        ex.getMessage(),
                        request));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage()));

        ValidationExceptionDto validationExceptionDto = new ValidationExceptionDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation Failed",
                request.getRequestURI(),
                errors
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(validationExceptionDto);

    }

    private ExceptionResponseDto buildResponse(
            HttpStatus status,
            String message,
            HttpServletRequest request) {

        return new ExceptionResponseDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                request.getRequestURI()
        );
    }
}