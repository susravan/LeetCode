package LeetCodeMediumQuestions;

import java.util.PriorityQueue;

/**
 * @author Sravan
 * Created on Apr 12, 2018
 */

/**
 * To an array and K, each element in the array can only move K positions to the left at most, no limit to the right, try to sort the array under the limit of K 
a = [5, 2, 4, 3, 1], k = 2 
Return [2, 3, 1, 4, 5]
 */

public class SortWithinKPositions {
	public int[] getSortedArray(int[] arr, int k) {
		if(arr == null || arr.length == 0)
			return arr;

		int[] res = new int[arr.length];
		
		int index = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i=0; i < arr.length; i++) {
			if(i <= k)
				q.add(arr[i]);
			else {
				res[index++] = q.poll();
				q.add(arr[i]);
			}
		}
		while(!q.isEmpty()) {
			res[index++] = q.poll();
		}
		return res;
	}
}
