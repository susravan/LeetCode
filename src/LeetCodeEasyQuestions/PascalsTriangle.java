package LeetCodeEasyQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sravan
 * Created on Jan 23, 2018
 */

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> currList = new ArrayList<>();
		currList.add(1);
		res.add(new ArrayList<>(currList));

		for (int i = 1; i < numRows; i++) {
			currList.clear();
			currList.add(1);
			List<Integer> temp = res.get(res.size() - 1);
			for (int j = 1; j < temp.size(); j++) {
				currList.add(temp.get(j) + temp.get(j - 1));
			}
			currList.add(1);
			res.add(new ArrayList<>(currList));
		}
		return res;
	}
}
