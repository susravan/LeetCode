package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 21, 2018
 */

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

public class UniqueBST {
	public int numTrees(int n) {
		if (n < 2)
			return 1;

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int num = 3; num <= n; num++) {
			for (int div = 1; div <= num; div++) {
				dp[num] += dp[div - 1] * dp[num - div];
			}
		}
		return dp[n];
	}
}
