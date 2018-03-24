package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Mar 23, 2018
 */

/**
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes",
 * word2 = "coding", return 1.
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2
 * are both in the list.
 * 
 * 
 */

// Inspired from
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		if (words.length == 0)
			return 0;

		int idx1 = -1, idx2 = -1, minDist = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				idx1 = i;
			if (words[i].equals(word2))
				idx2 = i;

			if (idx1 != -1 && idx2 != -1)
				minDist = Math.min(minDist, Math.abs(idx1 - idx2));
		}
		return minDist;
	}
}
