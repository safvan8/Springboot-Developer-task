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

@RestController
@RequestMapping("/api/terminology")
public class TerminologyController {

	@Autowired
	private ITerminologyService terminologyService;

	@PostMapping("/extract-from-file")
	public ResponseEntity<?> extractTerminology(@RequestParam("sample-text-file") MultipartFile multipartFile) {

		List<String> extractedTerminology = terminologyService.extractTerminology(multipartFile);

		// Return the extracted terminology as a response
		return ResponseEntity.ok(extractedTerminology);
	}
}
