package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Sravan
 * Created on Feb 26, 2018
 */

/**
 *Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.

 */

// Inspired from 
public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> wordMap = new HashMap<>();

		for (String word : words)
			wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);

		// Remember - The sorting in heap should be exactly opposite of what needs to be
		// expected in the output
		PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (wordMap.get(s1) == wordMap.get(s2))
					return s2.compareTo(s1);
				else
					return wordMap.get(s1) - wordMap.get(s2);
			}
		});

		// Add words to heap where sorting happens based on the map created in previous
		// step
		for (String word : wordMap.keySet()) {
			heap.offer(word);
			if (heap.size() > k)
				heap.poll();
		}

		List<String> res = new ArrayList<>();
		while (!heap.isEmpty()) {
			res.add(heap.poll());
		}
		Collections.reverse(res);
		return res;
	}
}
