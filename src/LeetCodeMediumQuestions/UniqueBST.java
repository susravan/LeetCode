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

		int[] memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = 1;
		memo[2] = 2;

		for (int i = 3; i <= n; i++) {
			// For n nodes, root position can be put from node1 to nodeN
			for (int rootPos = 1; rootPos <= i; rootPos++) {
				memo[i] += memo[rootPos - 1] * memo[i - rootPos]; // For each root position (rootPos), calculate the
																	// possible trees to its left and right side based
																	// on the no. of nodes on each side and add to
																	// result
			}
		}
		return memo[n];
	}
}
