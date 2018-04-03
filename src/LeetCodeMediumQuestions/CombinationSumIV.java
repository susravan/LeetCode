package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Apr 3, 2018
 */

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
 */


public class CombinationSumIV {
	// Answers for followup quesitons:
	// If negative numbers are allowed, there is high possibility that the
	// computation goes into infinite loop. As long as we choose n 1s and (n-1) -1s,
	// it always sums up to 1, n can be any value >= 1.
	// To avoid this, we need to add a condition that each number should be used
	// only once. This avoids infinite loop
	public int combinationSum4(int[] candidates, int target) {
		int[] memo = new int[target + 1];
		memo[0] = 1;

		for (int i = 1; i < memo.length; i++) {
			for (int j = 0; j < candidates.length; j++) {
				if (candidates[j] <= i)
					memo[i] += memo[i - candidates[j]];
			}
		}
		return memo[memo.length - 1];
	}
}
