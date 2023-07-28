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

	@ExceptionHandler(value = { MarkDownException.class, MarkDownParseException.class })
	public ResponseEntity<ErrorResponse> handleTouristNotFoundException(MarkDownException e) {

		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.toString());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
}
