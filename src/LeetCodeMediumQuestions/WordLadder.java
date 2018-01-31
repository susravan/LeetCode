package LeetCodeMediumQuestions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sravan
 *
 *         Given two words (start and end), and a dictionary, find the length of
 *         shortest transformation sequence from start to end, such that only
 *         one letter can be changed at a time and each intermediate word must
 *         exist in the dictionary. For example, given:
 * 
 *         start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] One
 *         shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *         the program should return its length 5.
 */

// Inspired from https://www.programcreek.com/2012/12/leetcode-word-ladder/
public class WordLadder {
	// Approach: 2-way BFS search. Do BFS search from begin and end words whichever
	// is less size and see if the new words formed are present in the other
	// directon's word list
	// This increases the memory requirement but will be faster than single
	// direction
	public int ladderLength(String beginWord, String endWord, List<String> dict) {
		Set<String> wordList = new HashSet<>(dict);
		if (!wordList.contains(endWord))
			return 0;

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		int len = 1;
		Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
		beginSet.add(beginWord);
		endSet.add(endWord);

		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			// Make beginSet point to least size set
			if (beginSet.size() > endSet.size()) {
				Set<String> tempSet = beginSet;
				beginSet = endSet;
				endSet = tempSet;
			}
			// System.out.println("Initial: " + beginSet.size() + " " + endSet.size());
			// Do actual calculation of changing the characters and looking for target
			Set<String> newSet = new HashSet<>();
			for (String word : beginSet) {
				char[] currChars = word.toCharArray();
				for (int i = 0; i < currChars.length; i++) {
					char temp = currChars[i];
					for (char ch = 'a'; ch <= 'z'; ch++) {
						currChars[i] = ch;
						String newWord = String.valueOf(currChars);

						if (endSet.contains(newWord))
							return len + 1;

						if (!visited.contains(newWord) && wordList.contains(newWord)) {
							visited.add(newWord);
							newSet.add(newWord);
						}
					}
					currChars[i] = temp;
				}
			}
			beginSet = newSet;
			len++;
			// System.out.println("Modified: " + beginSet.size() + " " + endSet.size());
		}

		return 0;
	}
}
