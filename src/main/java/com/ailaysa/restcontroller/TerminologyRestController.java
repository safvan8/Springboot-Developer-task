package com.ailaysa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ailaysa.service.ITerminologyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * REST Controller for handling Terminology related requests.
 * 
 * @author safvan
 *
 */
@RestController
@RequestMapping("/api/terminology")
@Api(value = "Terminology API", tags = "Terminology")
public class TerminologyRestController {

	@Autowired
	private ITerminologyService terminologyService;
	

    /**
     * Endpoint to extract terminology from a given plain text file.
     *
     * @param multipartFile the multipart file containing the plain text content.
     * @return a ResponseEntity with the extracted terminology as the response
     *         body. The response will have HTTP status 200 (OK) if the extraction
     *         is successful. If the uploaded file is empty or an exception occurs
     *         during processing, the response will contain an error message.
     */
    @ApiOperation(value = "Extract Terminology from Plain Text File",
            notes = "This endpoint extracts terminology from a given plain text file.")
	@PostMapping("/extract-from-file")
	public ResponseEntity<?> extractTerminology(@RequestParam("sample-text-file") MultipartFile multipartFile) {

		List<String> extractedTerminology = terminologyService.extractTerminology(multipartFile);

		// Return the extracted terminology as a response
		return ResponseEntity.ok(extractedTerminology);
	}
}
