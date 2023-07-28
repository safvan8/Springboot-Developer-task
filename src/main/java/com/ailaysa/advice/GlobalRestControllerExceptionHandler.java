package com.ailaysa.advice;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ailaysa.exception.MarkDownException;
import com.ailaysa.exception.MarkDownParseException;
import com.ailaysa.exception.TerminologyException;
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
	 * Exception handler for MarkDownException, MarkDownParseException, and
	 * TerminologyException. This method is triggered when any of these exceptions
	 * is thrown in any REST controller.
	 *
	 * @param e       the exception that was thrown.
	 * @param request the HttpServletRequest associated with the exception.
	 * @return a ResponseEntity with an ErrorResponse containing the error details
	 *         as the response body. The response will have HTTP status 500
	 *         (INTERNAL_SERVER_ERROR) to indicate that an internal server error
	 *         occurred.
	 */
	@ExceptionHandler(value = { MarkDownException.class, MarkDownParseException.class, TerminologyException.class })
	public ResponseEntity<ErrorResponse> handleTextProcessingExceptions(Exception e, HttpServletRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.toString(), request.getRequestURI());

		e.printStackTrace(); // logging exception to console

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

	/**
	 * Exception handler for all exceptions that are not handled by other specific
	 * exception handlers. This method is triggered when any unhandled exception is
	 * thrown in any REST controller.
	 * 
	 * @param e       the unhandled exception that was thrown.
	 * @param request the HttpServletRequest associated with the request that
	 *                triggered the exception.
	 * 
	 * @return a ResponseEntity with an ErrorResponse containing the error details
	 *         as the response body. The response will have HTTP status 400
	 *         (BAD_REQUEST) to indicate that a bad request was received.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception e, HttpServletRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.toString(), request.getRequestURI());
		e.printStackTrace(); // logging exception to console
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

}
