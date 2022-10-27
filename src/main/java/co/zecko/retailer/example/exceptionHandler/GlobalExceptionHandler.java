package co.zecko.retailer.example.exceptionHandler;

import co.zecko.retailer.exception.BaseException;
import java.util.Date;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pojo.ErrorEntry;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorEntry> handleBaseException(BaseException baseException) {
        logException(baseException);
        ErrorEntry errorEntry = new ErrorEntry(baseException.getMessage(), new Date(),
            baseException.getDetails());

        return new ResponseEntity<>(errorEntry,
            HttpStatus.valueOf(baseException.getHttpStatus().value()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorEntry> handleException(Exception exception) {
        logException(exception);
        ErrorEntry errorEntry = new ErrorEntry("Something went wrong!", new Date(), null);
        return new ResponseEntity<>(errorEntry, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorEntry> handleException(HttpMessageNotReadableException exception) {
        logException(exception);
        ErrorEntry errorEntry = new ErrorEntry(exception.getMessage(), new Date(), null);
        return new ResponseEntity<>(errorEntry, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorEntry> handleMissingServletRequestParameterException(
        MissingServletRequestParameterException exception) {

        logException(exception);
        ErrorEntry errorEntry = new ErrorEntry(exception.getMessage(), new Date());
        return new ResponseEntity<>(errorEntry, HttpStatus.BAD_REQUEST);
    }

    private void logException(Exception exception) {
        log.error(exception.getMessage());
        log.error(exception.toString());
        log.error("Exception: ", exception);
    }
}
