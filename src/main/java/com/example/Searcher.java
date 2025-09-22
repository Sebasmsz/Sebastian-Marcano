package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Searcher utility class for string list operations.
 */
public class Searcher {

	/**
	 * Checks if the exact phrase exists in the list.
	 * @param phrase the phrase to search for
	 * @param list the list of strings
	 * @return true if found, false otherwise
	 */
	public boolean searchExactPhrase(String phrase, List<String> list) {
		for (String item : list) {
			if (item.equals(phrase)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the word exists in the list (simple contains).
	 * @param word the word to search for
	 * @param list the list of strings
	 * @return true if found, false otherwise
	 */
	public boolean searchWord(String word, List<String> list) {
		return list.contains(word);
	}

	/**
	 * Get element by index safely.
	 * @param list the list of strings
	 * @param index the index to retrieve
	 * @return the string at index, or null if out of bounds
	 */
	public String getWordByIndex(List<String> list, int index) {
		if (index >= 0 && index < list.size()) {
			return list.get(index);
		}
		return null; // Avoid IndexOutOfBounds
	}

	/**
	 * Find elements starting with a given prefix.
	 * @param prefix the prefix to search for
	 * @param list the list of strings
	 * @return list of elements starting with prefix
	 */
	public List<String> searchByPrefix(String prefix, List<String> list) {
		List<String> results = new ArrayList<>();
		for (String element : list) {
			if (element.startsWith(prefix)) {
				results.add(element);
			}
		}
		return results;
	}

	/**
	 * Filter all elements that contain a given keyword.
	 * @param keyword the keyword to filter by
	 * @param list the list of strings
	 * @return list of elements containing the keyword
	 */
	public List<String> filterByKeyword(String keyword, List<String> list) {
		List<String> results = new ArrayList<>();
		for (String element : list) {
			if (element.contains(keyword)) {
				results.add(element);
			}
		}
		return results;
	}
}
