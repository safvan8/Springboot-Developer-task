package com.ailaysa.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ailaysa.exception.TerminologyException;
import com.ailaysa.service.ITerminologyService;

@Service
public class TerminologyServiceImpl implements ITerminologyService {

	@Override
	public List<String> extractTerminology(MultipartFile file) {

		String plainTextContent = null;
		try {
			// Read the content of the uploaded file and convert it to a string
			plainTextContent = new String(file.getBytes(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new TerminologyException(
					"exception occured while reading the file , error message:" + e.getMessage());
		}
		
		List<String> terminologyList = new ArrayList<>();

		// Split the plain text into words based on whitespace characters
		String[] words = plainTextContent.split("\\s+");

		for (String word : words) {
			// Check if the word starts with an uppercase letter (assumed as a terminology)
			if (!word.isEmpty() && Character.isUpperCase(word.charAt(0))) {
				terminologyList.add(word);
			}
		}
		return terminologyList;
	}
}
