package LeetCodeMediumQuestions;

import java.util.HashMap;

/**
 * @author sravan created on Sep 16, 2017
 *
 */

/*
 * Implement a MapSum class with insert, and sum methods.
 * 
 * For the method insert, you'll be given a pair of (string, integer). The
 * string represents the key and the integer represents the value. If the key
 * already existed, then the original key-value pair will be overridden to the
 * new one.
 * 
 * For the method sum, you'll be given a string representing the prefix, and you
 * need to return the sum of all the pairs' value whose key starts with the
 * prefix.
 * 
 * Example 1: Input: insert("apple", 3), Output: Null Input: sum("ap"), Output:
 * 3 Input: insert("app", 2), Output: Null Input: sum("ap"), Output: 5
 *
 */

// Inspired from
public class MapSumPairs {

	HashMap<String, Integer> map = new HashMap<>();

	public MapSumPairs() {

	}

	public void insert(String key, int val) {
		this.map.put(key, val);
	}

	public int sum(String prefix) {
		int sum = 0;
		for (String keyStr : map.keySet()) {
			if (keyStr.startsWith(prefix))
				sum += map.get(keyStr);
		}
		return sum;
	}
}
