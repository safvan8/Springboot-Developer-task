package com.ailaysa.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ailaysa.exception.MarkDownException;
import com.ailaysa.exception.MarkDownParseException;
import com.ailaysa.service.IMarkDownService;

/**
 * MarkDownServiceImpl is an implemenatation class containing implentation for
 * all MarkDown file related operations.
 * 
 * @author safvan
 *
 */
@Service
public class MarkDownServiceImpl implements IMarkDownService {

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
	@Override
	public String convertMarkdownFileToString(MultipartFile file) {
		if (file.isEmpty()) {
			throw new MarkDownException("Uploaded file is empty or No files uploaded");
		}

		String markDownContent = null;

		// Read the content of the uploaded file and return it as a String
		try {
			InputStream inputStream = file.getInputStream();
			markDownContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

		} catch (IOException e) {
			throw new MarkDownParseException("Exception occured while reading markDownFile" + e.getMessage());
		} catch (Exception e) {
			throw new MarkDownException("Exception occured while processing Markdown file" + e.getMessage());
		}
		return markDownContent;
	}
}
