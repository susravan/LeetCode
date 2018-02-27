package LeetCodeDifficultQuestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sravan
 * Given a collection of intervals, merge all overlapping
 *         intervals.
 * 
 *         For example, Given [1,3],[2,6],[8,10],[15,18], return
 *         [1,6],[8,10],[15,18].
 *
 * 
 */

// Inspired from https://leetcode.com/problems/merge-intervals/solution/
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		// Approach: Sort the given intervals by creating a comparator class.
		// Modify the existing list itself to merge the intervals
		Collections.sort(intervals, new IntervalComparator());

		int i = 0;
		while (i < intervals.size()) {
			if (i == 0 || intervals.get(i - 1).end < intervals.get(i).start)
				i++;
			else {
				intervals.get(i - 1).end = Math.max(intervals.get(i - 1).end, intervals.get(i).end);
				intervals.remove(i);
			}
		}
		return intervals;
	}
	
	// Comparator class to compare 2 Interval objects
	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval first, Interval second) {
			return first.start < second.start ? -1 : (first.start == second.start ? 0 : 1);
		}
	}
}
