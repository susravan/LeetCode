package LeetCodeMediumQuestions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sravan
 * Created on Apr 21, 2018
 */

/**
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

For each integer in this list:
The hundreds digit represents the depth D of this node, 1 <= D <= 4.
The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
The units digit represents the value V of this node, 0 <= V <= 9.
Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.

Example 1:
Input: [113, 215, 221]
Output: 12
Explanation: 
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.
Example 2:
Input: [113, 221]
Output: 4
Explanation: 
The tree that the list represents is: 
    3
     \
      1

The path sum is (3 + 1) = 4.
 */


public class SumPathIV {
	public int getSum(int[] nums) {
		int sum = 0, index = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(nums[index++]);
		
		// Push to queue the next height elements of the tree
		while (!q.isEmpty()) {
			sum = sum * q.size();
			int nextDepth = q.peek() / 100 + 1;
			while(!q.isEmpty()) {
				sum += (q.poll() % 10);
			}
			
			while (index < nums.length && nums[index] / 100 == nextDepth) {
				q.offer(nums[index++]);
			}
		}
		return sum;
	}
}