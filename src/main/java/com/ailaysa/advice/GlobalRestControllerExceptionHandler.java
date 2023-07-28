package com.ailaysa.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ailaysa.exception.MarkDownException;
import com.ailaysa.exception.MarkDownParseException;
import com.ailaysa.response.ErrorResponse;

/**
 * Global Exception Handler for REST Controllers. This class handles exceptions
 * thrown by REST controllers in the application.
 * 
 * @author safvan
 *
 */
@RestControllerAdvice
public class GlobalRestControllerExceptionHandler {
	/**
	 * Exception handler for MarkDownException and MarkDownParseException. This
	 * method is triggered when either of these exceptions is thrown in any REST
	 * controller.
	 * 
	 * @param e the MarkDownException or MarkDownParseException that was thrown.
	 * 
	 * @return a ResponseEntity with an ErrorResponse containing the error details
	 *         as the response body. The response will have HTTP status 500
	 *         (INTERNAL_SERVER_ERROR) to indicate that an internal server error
	 *         occurred.
	 */
	@ExceptionHandler(value = { MarkDownException.class, MarkDownParseException.class })
	public ResponseEntity<ErrorResponse> handleTouristNotFoundException(MarkDownException e) {

		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.toString());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
}
