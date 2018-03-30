package LeetCodeMediumQuestions;

import java.util.List;

/**
 * @author Sravan
 * Created on Mar 30, 2018
 */

/**
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * For example, given two 1d vectors:
 * 
 * v1 = [1, 2] v2 = [3, 4, 5, 6] By calling next repeatedly until hasNext
 * returns false, the order of elements returned by next should be: [1, 3, 2, 4,
 * 5, 6]
 * 
 * Follow up: What if you are given k 1d vectors? How well can your code be
 * extended to such cases?
 * 
 * 
 */

// Inspired from
public class ZigzagIterator {
	int listIndex, eleIndex;
	Integer num;
	List<List<Integer>> list;

	public ZigzagIterator(List<List<Integer>> list) {
		this.list = list;
		listIndex = eleIndex = 0;
		if (list.get(listIndex).size() > 0)
			num = list.get(listIndex).get(eleIndex);
		else
			num = null;
	}

	public int next() {
		if (num == null)
			throw new NullPointerException();

		int res = num;
		listIndex++;

		// If the eleIndex is greater than curr list size, go to next list
		while (listIndex < list.size() && eleIndex >= list.get(listIndex).size())
			listIndex++;

		// Go back to first list when end of list is reached
		if (listIndex == list.size()) {
			listIndex = 0;
			eleIndex++;

			// When eleIndex reaches the maximum size of sublist, update num to null
			while (listIndex < list.size() && eleIndex >= list.get(listIndex).size()) {
				listIndex++;
			}
		}

		if (listIndex == list.size())
			num = null;
		else
			num = list.get(listIndex).get(eleIndex);

		return res;
	}

	public boolean hasNext() {
		return num != null;
	}
}
