package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Sravan
 * Created on Apr 4, 2018
 */

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */

// Inspired from 
public class SortCharByFrequency {
	public String frequencySort(String s) {
		if (s.equals("") || s.length() == 1)
			return s;

		StringBuilder res = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();
		int maxCount = 0;
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			maxCount = Math.max(maxCount, map.get(ch));
		}

		List<Character>[] charList = new List[maxCount + 1];
		for (char ch : map.keySet()) {
			int freq = map.get(ch);
			if (charList[freq] == null)
				charList[freq] = new LinkedList<>();
			charList[freq].add(ch);
		}
		// System.out.println(charList[2]);

		for (int i = charList.length - 1; i >= 0; i--) {
			if (charList[i] == null)
				continue;
			for (char ch : charList[i]) {
				for (int j = 0; j < i; j++)
					res.append(ch);
			}
		}

		return res.toString();
	}
}
