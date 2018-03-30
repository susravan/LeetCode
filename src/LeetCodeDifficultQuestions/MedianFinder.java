package LeetCodeDifficultQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sravan
 * Created on Mar 29, 2018
 */

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 */

// Inspired from https://leetcode.com/articles/find-median-from-data-stream/
public class MedianFinder {
	private PriorityQueue<Integer> lowerHeap;
	private PriorityQueue<Integer> higherHeap;

	// See the reference page for explanation
	public MedianFinder() {
		lowerHeap = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});
		higherHeap = new PriorityQueue<>();

	}

	public void addNum(int num) {
		// lowerHeap.add(num);
		if (higherHeap.size() == 0 || num < higherHeap.peek())
			lowerHeap.add(num);
		else
			higherHeap.add(num);

		if (lowerHeap.size() < higherHeap.size())
			lowerHeap.offer(higherHeap.poll());
		else if (lowerHeap.size() - higherHeap.size() > 1)
			higherHeap.offer(lowerHeap.poll());

	}

	public double findMedian() {
		if (lowerHeap.size() == 0)
			return 0;
		if (lowerHeap.size() == higherHeap.size())
			return (double) (lowerHeap.peek() + higherHeap.peek()) / 2;
		else
			return lowerHeap.peek();
	}
}
