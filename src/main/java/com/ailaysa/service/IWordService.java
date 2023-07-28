package com.ailaysa.service;

/**
 * Iword contains the all the service requirement specifictaions for Word
 * related services.
 * 
 * @author safvan
 *
 */
public interface IWordService {

	/**
	 * Count the number of words in the given sentence.
	 *
	 * @param sentence The input sentence for which to count the words.
	 * @return The number of words in the sentence. If the sentence is null or
	 *         empty, the method returns 0.
	 */
	public Integer getCountOfWordsInSenetence(String sentence);
}
