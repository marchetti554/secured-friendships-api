package org.mmarchetti.secured.friendships.api.exception.error;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 *  Model class that represents the final output of an error.
 *
 * @author Marco Marchetti
 */
@Data
@Builder
public class ErrorOutput {

    private String errorMessage;
    private ErrorCode errorCode;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
}
