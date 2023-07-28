package com.ailaysa.restcontroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ailaysa.exception.MarkDownException;
import com.ailaysa.exception.MarkDownParseException;
import com.ailaysa.service.IMarkDownService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *  REST Controller for handling Markdown file related requests.
 * 
 * @author safvan
 *
 */
@RestController
@RequestMapping("/api/mdcontent")
@Api(value = "Markdown Content API",tags = "Markdown")
public class MarkdownContentRestController {

	@Autowired
	private IMarkDownService markDownService;

	/**
	 * Endpoint to convert a Markdown file to a String representation.
	 * 
	 * @param multipartFile the multipart file containing the Markdown content.
	 * @return a ResponseEntity with the converted Markdown content as the response
	 *         body. The response will have HTTP status 200 (OK) if the conversion
	 *         is successful. If the uploaded file is empty or an exception occurs
	 *         during processing, the response will this method will return
	 *         ErrorResponse Object with exception details.
	 * @throws MarkDownException      if the uploaded file is empty or if an
	 *                                exception occurs during processing.
	 * @throws MarkDownParseException if an exception occurs while reading the
	 *                                Markdown file.
	 */
	@ApiOperation("To convert a Markdown file to a String representation")
	@PostMapping("/convert-to-string")
	public ResponseEntity<?> getMarkdownContent(@RequestParam("markdown-sample") MultipartFile multipartFile)
			throws IOException {
		String markDownContent = markDownService.convertMarkdownFileToString(multipartFile);
		return ResponseEntity.ok().body(markDownContent);
	}
}
