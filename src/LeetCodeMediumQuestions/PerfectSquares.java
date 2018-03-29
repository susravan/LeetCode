package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Mar 28, 2018
 */

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 */

public class PerfectSquares {
	public int numSquares(int n) {
		// Using Bottom-Up dynamic programming approach
		if (n < 4)
			return n;

		// Populate array with base cases
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		// For each number after that, calculate number of ways and
		for (int i = 4; i <= n; i++) {
			int x = 1, sqRoot = (int) Math.sqrt(i);
			// Maximum steps is always equal to number itself
			dp[i] = i;

			// Maximum x that can be subtracted = sqroot of that number
			while (x <= sqRoot) {
				dp[i] = Math.min(dp[i], dp[i - (x * x)] + 1);
				x++;
			}
		}
		// System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}
