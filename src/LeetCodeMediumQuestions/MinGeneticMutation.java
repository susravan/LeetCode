package LeetCodeMediumQuestions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sravan
 * Created on Jan 31, 2018
 */

/**
 * A gene string can be represented by an 8-character long string, with choices
 * from "A", "C", "G", "T".
 * 
 * Suppose we need to investigate about a mutation (mutation from "start" to
 * "end"), where ONE mutation is defined as ONE single character changed in the
 * gene string.
 * 
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * 
 * Also, there is a given gene "bank", which records all the valid gene
 * mutations. A gene must be in the bank to make it a valid gene string.
 * 
 * Now, given 3 things - start, end, bank, your task is to determine what is the
 * minimum number of mutations needed to mutate from "start" to "end". If there
 * is no such a mutation, return -1.
 * 
 * Note:
 * 
 * Starting point is assumed to be valid, so it might not be included in the
 * bank. If multiple mutations are needed, all mutations during in the sequence
 * must be valid. You may assume start and end string is not the same. Example
 * 1:
 * 
 * start: "AACCGGTT" end: "AACCGGTA" bank: ["AACCGGTA"]
 * 
 * return: 1 Example 2:
 * 
 * start: "AACCGGTT" end: "AAACGGTA" bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 
 * return: 2 Example 3:
 * 
 * start: "AAAAACCC" end: "AACCCCCC" bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 
 * return: 3
 * 
 */

public class MinGeneticMutation {
	public int minMutation(String start, String end, String[] bank) {
		Set<String> wordSet = new HashSet<>();
		for (int i = 0; i < bank.length; i++) {
			wordSet.add(bank[i]);
		}

		if (!wordSet.contains(end))
			return -1;

		Set<String> visited = new HashSet<>();
		visited.add(start);
		int len = 1;
		Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
		beginSet.add(start);
		endSet.add(end);
		Set<Character> possibleChars = new HashSet<>();
		possibleChars.add('A');		possibleChars.add('T');
		possibleChars.add('G');		possibleChars.add('C');
		
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			// Make beginSet point to least size set
			if (beginSet.size() > endSet.size()) {
				Set<String> tempSet = beginSet;
				beginSet = endSet;
				endSet = tempSet;
			}
			System.out.println("Initial: " + beginSet.size() + " " + endSet.size());

			// Do actual calculation of changing the characters and looking for target
			Set<String> newSet = new HashSet<>();
			for (String word : beginSet) {
				char[] currChars = word.toCharArray();
				for (int i = 0; i < currChars.length; i++) {
					char temp = currChars[i];
					for (char ch: possibleChars) {
						currChars[i] = ch;
						String newWord = String.valueOf(currChars);
						if (endSet.contains(newWord))
							return len;

						if (!visited.contains(newWord) && wordSet.contains(newWord)) {
							visited.add(newWord);
							newSet.add(newWord);
						}
					}
					currChars[i] = temp;
				}
			}
			beginSet = newSet;
			len++;
			System.out.println("Modified: " + beginSet.size() + " " + endSet.size());
		}
		return -1;
	}
}
