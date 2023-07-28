package com.ailaysa.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TerminologyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**
	 * The custom message to describe the Markdown processing error.
	 */
	private String customMessage = null;

	/**
	 * Constructs a new TerminologyException with the specified custom message.
	 * 
	 * @param customMessage the custom message to describe the Terminology
	 *                      processing error.
	 */
	public TerminologyException(String customMessage) {
		super(customMessage);
		this.customMessage = customMessage;
	}
}
