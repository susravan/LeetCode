package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sravan
 * Created on Mar 23, 2018
 */

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you
 * are given the list of words and your method will be called repeatedly many
 * times with different parameters. How would you optimize it?
 * 
 * Design a class which receives a list of words in the constructor, and
 * implements a method that takes two words word1 and word2 and return the
 * shortest distance between these two words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes",
 * word2 = "coding", return 1.
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2
 * are both in the list.
 */

// Inspired from
public class ShortestDistanceII {
	Map<String, List<Integer>> map;

	public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i=0; i < words.length; i++) {
            if(!map.containsKey(words[i]))
                map.put(words[i], new ArrayList<>());
            
            map.get(words[i]).add(i);
        }
    }

	public int shortest(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);

		int minDist = Integer.MAX_VALUE;
		int idx1 = 0, idx2 = 0;
		while (idx1 < list1.size() && idx2 < list2.size()) {
			int num1 = list1.get(idx1);
			int num2 = list2.get(idx2);
			minDist = Math.min(minDist, Math.abs(num1 - num2));
			if (num1 < num2)
				idx1++;
			else
				idx2++;
		}
		return minDist;
	}
}
