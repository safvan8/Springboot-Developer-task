package com.ailaysa.service;

import org.springframework.web.multipart.MultipartFile;

import com.ailaysa.exception.MarkDownParseException;

/**
 * IMarkDownService conatins all service requirement specification for all
 * MarkDown related services.
 * 
 * @author safvan
 *
 */
public interface IMarkDownService {

	/**
	 * Converts a Markdown file to a String representation. The method reads the
	 * content of the uploaded file and returns it as a String.
	 * 
	 * @param file the Markdown file to be converted.
	 * @return the content of the Markdown file as a String.
	 * @throws MarkDownException      if the uploaded file is empty or if an
	 *                                exception occurs during processing.
	 * @throws MarkDownParseException if an exception occurs while reading the
	 *                                Markdown file.
	 */
	public String convertMarkdownFileToString(MultipartFile markdownFile) throws MarkDownParseException;
}
