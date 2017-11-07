package LeetCodeMediumQuestions;

/**
 * @author sravan
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */

// Inspired from https://discuss.leetcode.com/topic/20064/my-concise-o-m-n-java-solution/2

public class Search2DMatrixII {
	// Approach - Take out one row or column each time you visit the top right
	// corner element by comparing the target to it - O(M+N) solution
	
	public boolean search2DMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		int row = 0, col = matrix[0].length - 1;
		
		while(row < matrix.length && col >= 0) {
			if(matrix[row][col] == target)
				return true;
			else if(matrix[row][col] < target)
				row++;
			else
				col--;
		}
		return false;
	}
}
