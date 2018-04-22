package LeetCodeMediumQuestions;

import java.util.Iterator;
import java.util.LinkedList;
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

public class ZigzagIterator {
	private List<Iterator> iterList;
	private int index, nextNum;

	public ZigzagIterator(List<List<Integer>> list) {
		iterList = new LinkedList<>();
		for (List<Integer> temp : list)
			iterList.add(temp.iterator());
	}

	public int next() {
		if (!hasNext())
			throw new NullPointerException();

		return (int) iterList.get(index++).next();
	}

	public boolean hasNext() {
		if (index >= iterList.size())
			index = 0;
		while (iterList.size() != 0 && !iterList.get(index).hasNext()) {
			iterList.remove(index);
			if (index >= iterList.size())
				index = 0;
		}
		return iterList.size() != 0;
	}
}
