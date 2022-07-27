package org.mmarchetti.secured.friendships.api.exception.handler;

import org.mmarchetti.secured.friendships.api.exception.error.ErrorCode;
import org.mmarchetti.secured.friendships.api.exception.error.ErrorOutput;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 *  Handles all errors and exceptions interactions.
 *
 * @author Marco Marchetti
 */
@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErrorOutput> handleDuplicateKeyException(DuplicateKeyException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return ResponseEntity
                .status(httpStatus)
                .body(ErrorOutput.builder()
                        .errorCode(ErrorCode.DUPLICATE_KEY)
                        .errorMessage(exception.getMessage())
                        .httpStatus(httpStatus)
                        .timestamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorOutput> handleNullPointerException(NullPointerException exception) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(httpStatus)
                .body(ErrorOutput.builder()
                        .errorCode(ErrorCode.NULL_REFERENCE)
                        .errorMessage(exception.getMessage())
                        .httpStatus(httpStatus)
                        .timestamp(LocalDateTime.now())
                        .build());
    }

}
