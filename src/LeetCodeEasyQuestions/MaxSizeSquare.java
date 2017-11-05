package LeetCodeEasyQuestions;

/**
 * @author sravan
 * Given a matrix containing 0 and 1, find the size of the maximum square matrix of 1s and return its size
 */
public class MaxSizeSquare {
	
	// Approach: Use DP to get the largest size of the matrix until each point
	public int getMaxSquareMatrix(int[][] matrix) {
		
		int len = matrix.length, wid = matrix[0].length;
		// DP matrix with 1 higher than the number of rows and columns
		int[][] memo = new int[len+1][wid+1];
		int maxSize = 0;

		// If curr element is 1, take minimum of previous 3 numbers and add 1 to
		// indicate that including this element would form a square of 1s but the total
		// total size would be limited by the smallest size of the square before this 1
		// is included 
		for(int row=1; row < memo.length; row++) {
			for(int col=1; col < memo[0].length; col++) {
				if(matrix[row-1][col-1] == 1)
					memo[row][col] = Math.min(Math.min(memo[row-1][col-1], memo[row-1][col]), memo[row][col-1]) + 1;
				else
					memo[row][col] = 0;
				maxSize = Math.max(maxSize, memo[row][col]);
			}
		}
		return maxSize;
	}
}
