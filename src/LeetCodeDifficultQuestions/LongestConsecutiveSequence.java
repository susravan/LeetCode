package LeetCodeDifficultQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sravan
 * Created on Feb 27, 2018
 */

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */

// Inspired from
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums)
			set.add(num);

		int maxSeqLen = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i] - 1)) {
				int currSeq = 1;
				int nextNum = nums[i] + 1;

				while (set.contains(nextNum)) {
					currSeq++;
					nextNum++;
				}
				maxSeqLen = Math.max(maxSeqLen, currSeq);
			}
		}
		return maxSeqLen;
	}
}
