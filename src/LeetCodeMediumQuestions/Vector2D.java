package LeetCodeMediumQuestions;

import java.util.Iterator;
import java.util.List;

/**
 * @author Sravan
 * Created on Mar 30, 2018
 */

/**
 * Implement an iterator to flatten a 2d vector.
 * 
 * For example, Given 2d vector =
 * 
 * [ [1,2], [3], [4,5,6] ] By calling next repeatedly until hasNext returns
 * false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */

// Inspired from
public class Vector2D implements Iterator<Integer> {
	private Iterator<List<Integer>> interListIter;
	private Iterator<Integer> intraListIter;

	public Vector2D(List<List<Integer>> vec2d) {
		interListIter = vec2d.iterator();
		intraListIter = interListIter.hasNext() ? interListIter.next().iterator() : null;
	}

	@Override
	public Integer next() {
		hasNext();
		return intraListIter.next();
	}

	@Override
	public boolean hasNext() {
		if ((intraListIter == null || !intraListIter.hasNext()) && interListIter.hasNext())
			intraListIter = interListIter.next().iterator();

		return intraListIter != null && intraListIter.hasNext();
	}
}
