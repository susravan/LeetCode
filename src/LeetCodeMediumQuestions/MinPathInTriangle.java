package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sravan
 * Created on Jan 25, 2018
 */

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

// Inspired from 
public class MinPathInTriangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		List<Integer> memo = triangle.get(triangle.size() - 1);

		for (int i = triangle.size() - 2; i >= 0; i--) {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < triangle.get(i).size(); j++) {
				temp.add(triangle.get(i).get(j) + Math.min(memo.get(j), memo.get(j + 1)));
			}
			// Because not modify operations are being done on temp after this step, we can
			// directly assign temp to memp list
			// Creating new list doesn't effect the old variable assignments
			memo = temp;
		}
		return memo.get(0);
	}
}
