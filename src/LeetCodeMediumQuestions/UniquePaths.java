package LeetCodeMediumQuestions;

/**
 * @author sravan
 * created on Aug 6, 2017
 *
 */

/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 *
 */


public class UniquePaths {

	public int getUniquePaths(int m, int n) {
		if(m == 0 || n == 0)
            return 1;
        
        // Approach - Using DP by storing number of possible paths for each square in the board using a 2D matrix
        int[][] memo = new int[m][n];
        memo[0][0] = 0;
        for(int row=0; row < m; row++)
            memo[row][0] = 1;
        for(int col=0; col < n; col++)
            memo[0][col] = 1;
        
        for(int row = 1; row < m; row++) {
            for(int col = 1; col < n; col++) {
                memo[row][col] = memo[row - 1][col] + memo[row][col - 1];
                // System.out.println("Value at row " + row + " at col " + col + " = " + memo[row][col]);
            }
        }
        return memo[m - 1][n - 1];
	}

}
