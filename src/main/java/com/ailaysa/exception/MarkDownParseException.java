package com.ailaysa.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Custom exception to handle parsing errors related to Markdown content. This
 * exception is thrown when there is an issue parsing the Markdown content. It
 * can be used to provide more specific error information for parsing failures.
 * 
 * 
 * @author safvan
 */

@Getter
@Setter
public class MarkDownParseException extends MarkDownException {

	private static final long serialVersionUID = 1L;

	/**
	 * The custom message to describe the Markdown processing error.
	 */
	private String customMessage = null;

	/**
	 * Constructs a new MarkDownParseException with the specified custom message.
	 * 
	 * @param customMessage the custom message to describe the parsing error.
	 * 
	 */
	public MarkDownParseException(String customMessage) {
		super(customMessage);
		this.customMessage = customMessage;
	}
}