package cc.synpulse8.userservice.infrastructure.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException error) {

        List<FieldError> fieldErrors = error.getBindingResult().getFieldErrors();

        StringBuilder errorFields = new StringBuilder();

        for (FieldError fieldError : fieldErrors) {
            if (!errorFields.isEmpty()) {
                errorFields.append(", ");
            }
            errorFields.append(fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseErrorDto(HttpStatus.BAD_REQUEST,
                        GlobalServiceException.GlobalServiceErrorType.INPUT_FORMAT_ERROR.getErrorCode(),
                        errorFields.toString()));

    }

    @ExceptionHandler(GlobalServiceException.class)
    public ResponseEntity<ResponseErrorDto> handleCustomServiceException(GlobalServiceException error) {

        if(error.getErrorType().getErrorLevel().equals(GlobalErrorLevel.HEIGH)) {
            log.error(error.getMessage());
            //Consider to send error message to MQ
        }

        log.info("User-Service Exception Code: " + error.getErrorType().getErrorCode());
        log.info("User-Service Exception Message: " + error.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseErrorDto(HttpStatus.BAD_REQUEST, error.getErrorType().getErrorCode(), error.getMessage()));
    }

}
