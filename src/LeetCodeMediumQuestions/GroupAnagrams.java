package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of strings, group anagrams together.
	
	For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	Return:
	
	[
	  ["ate", "eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	Note: All inputs will be in lower-case.
*/

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < strs.length; i++) {
			char[] chrArr = strs[i].toCharArray();
			int[] charCount = new int[26];

			for (int j = 0; j < chrArr.length; j++)
				charCount[chrArr[j] - 'a']++;

			sb.setLength(0);
			for (int j = 0; j < 26; j++) {
				sb.append(charCount[j]).append("#");
			}
			String key = sb.toString();
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(strs[i]);
		}
		return new ArrayList(map.values());
	}

}
