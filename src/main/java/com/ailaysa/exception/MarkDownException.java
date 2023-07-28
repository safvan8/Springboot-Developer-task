package com.ailaysa.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Custom exception to handle any Generalized errors related to Markdown
 * content. This exception is thrown when there is an issue processing Markdown
 * content. It can be used to provide more specific error information for
 * different scenarios.
 * 
 * @author safvan
 *
 */

@Getter
@Setter
public class MarkDownException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * The custom message to describe the Markdown processing error.
	 */
	private String customMessage = null;

	/**
	 * Constructs a new MarkDownException with the specified custom message.
	 * 
	 * @param customMessage the custom message to describe the Markdown processing
	 *                      error.
	 */
	public MarkDownException(String customMessage) {
		super(customMessage);
		this.customMessage = customMessage;
	}
}
