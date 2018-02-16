package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sravan created on Oct 5, 2017
 *
 */

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 * [1,2,3,6,9,8,7,4,5].
 *
 */

// Inspired from https://leetcode.com/problems/spiral-matrix/solution/
public class SpiralMatrix {

	public List<Integer> getSpiralMatrix(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		if (matrix.length == 0)
			return ans;
		int r1 = 0, r2 = matrix.length - 1;
		int c1 = 0, c2 = matrix[0].length - 1;
		while (r1 <= r2 && c1 <= c2) {
			for (int c = c1; c <= c2; c++)
				ans.add(matrix[r1][c]);
			r1++;
			for (int r = r1; r <= r2; r++)
				ans.add(matrix[r][c2]);
			c2--;

			// This condition is put to avoid writing separate result for base cases like
			// single row and single column
			// Otherwise this logic works fine for square and rectangular matrices
			// Given a single row/ column would result in duplicate items if this check is
			// not made because both r1 and c2 are modified before this (and inside the
			// loop)
			if (r1 <= r2 && c1 <= c2) {
				for (int c = c2; c >= c1; c--)
					ans.add(matrix[r2][c]);
				r2--;
				for (int r = r2; r >= r1; r--)
					ans.add(matrix[r][c1]);
				c1++;
			}
		}
		return ans;
	}

}
