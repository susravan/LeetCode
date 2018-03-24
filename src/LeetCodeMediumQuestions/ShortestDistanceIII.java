package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Mar 23, 2018
 */

/**
 * This is a follow up of Shortest Word Distance. The only difference is now
 * word1 could be the same as word2.
 * 
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * word1 and word2 may be the same and they represent two individual words in
 * the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = “makes”, word2 = “coding”, return 1. Given word1 = "makes",
 * word2 = "makes", return 3.
 * 
 * Note: You may assume word1 and word2 are both in the list.
 */

// Inspired from
public class ShortestDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int minDist = Integer.MAX_VALUE;
		int idx1 = -1, idx2 = -1;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				idx1 = i;
			if (idx1 != -1 && idx2 != -1 && idx1 != idx2)
				minDist = Math.min(minDist, Math.abs(idx1 - idx2));

			if (words[i].equals(word2))
				idx2 = i;
			if (idx1 != -1 && idx2 != -1 && idx1 != idx2)
				minDist = Math.min(minDist, Math.abs(idx1 - idx2));
		}
		return minDist;
	}
}
