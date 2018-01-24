package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 23, 2018
 */

/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */

// Inspired from
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/
public class PopulateNextPointerBT {
	public void connect(TreeLinkNode root) {
		TreeLinkNode levelLeftNode = root;
		TreeLinkNode nodePointer = null;

		// Be at one level up, starting from leftmost node, take care of children, move
		// to next pointer and do the same. In the process maintiain the leftmost node
		// as prev and update it once that level is done
		while (levelLeftNode != null) {
			nodePointer = levelLeftNode;
			while (nodePointer != null) {
				if (nodePointer.left != null)
					nodePointer.left.next = nodePointer.right;
				if (nodePointer.right != null && nodePointer.next != null)
					nodePointer.right.next = nodePointer.next.left;
				nodePointer = nodePointer.next;
			}
			levelLeftNode = levelLeftNode.left;
		}
	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
