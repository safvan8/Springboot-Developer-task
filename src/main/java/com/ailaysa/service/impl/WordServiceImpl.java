package com.ailaysa.service.impl;

import org.springframework.stereotype.Service;

import com.ailaysa.service.IWordService;

/**
 * Service implementation class for all word related operations.
 * 
 * @author safvan
 *
 */
@Service
public class WordServiceImpl implements IWordService {

	/**
	 * Count the number of words in the given sentence.
	 *
	 * @param sentence The input sentence for which to count the words.
	 * @return The number of words in the sentence. If the sentence is null or
	 *         empty, the method returns 0.
	 */
	@Override
	public Integer getCountOfWordsInSenetence(String sentence) {
		if (sentence == null || sentence.trim().isEmpty()) {
			return 0;
		}

		// Split the sentence by whitespace characters to count words
		String[] words = sentence.trim().split("\\s+");
		return words.length;
	}
}
