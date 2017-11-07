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

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		
		// Approach - Dual binary search - first for getting the row, second for getting
		// the element in the row
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int len = matrix.length, wid = matrix[0].length;
		int lo = 0, high = len - 1;

		while (lo < high) {
			int mid = lo + (high - lo + 1) / 2;
			if (matrix[mid][0] <= target)
				lo = mid;
			else
				high = mid - 1;
		}
		int fixRow = lo;

		lo = 0;
		high = wid - 1;
		System.out.println("Fixed on row = " + fixRow);

		while (lo <= high) {
			int mid = lo + (high - lo) / 2;
			if (matrix[fixRow][mid] == target)
				return true;
			else if (matrix[fixRow][mid] < target)
				lo = mid + 1;
			else
				high = mid - 1;
		}
		return false;
		
//		 Approach - Treating the matrix as a single array of increasing sequence
		
		// int row_num = matrix.length;
		// int col_num = matrix[0].length;
		//
		// int begin = 0, end = row_num * col_num - 1;
		//
		// while(begin <= end){
		// int mid = (begin + end) / 2;
		// int mid_value = matrix[mid/col_num][mid%col_num];
		//
		// if( mid_value == target){
		// return true;
		//
		// }else if(mid_value < target){
		// //Should move a bit further, otherwise dead loop.
		// begin = mid+1;
		// }else{
		// end = mid-1;
		// }
		// }
		//
		// return false;
    }
}
