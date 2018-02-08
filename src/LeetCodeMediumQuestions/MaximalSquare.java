package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Feb 7, 2018
 */

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int len = matrix.length, wid = matrix[0].length;
        int[][] memo = new int[len][wid];
        int maxLen = 0;
        
        for(int row=0; row < len; row++) {
            for(int col=0; col < wid; col++) {
                if(row == 0 || col == 0)
                    memo[row][col] = matrix[row][col]-'0';
                else if(matrix[row][col] == '1') {
                        memo[row][col] = Math.min(Math.min(memo[row-1][col], memo[row][col-1]), memo[row-1][col-1]) + 1;
                }
                maxLen = Math.max(maxLen, memo[row][col]);
            }
        }
        return maxLen * maxLen;
    }
}
