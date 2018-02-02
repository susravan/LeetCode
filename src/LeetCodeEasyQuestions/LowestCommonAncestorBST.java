package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Feb 1, 2018
 */

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */

public class LowestCommonAncestorBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode pointer = root;
		if (p.val > q.val) {
			TreeNode temp = p;
			p = q;
			q = temp;
		}

		while (pointer != null) {
			if (p.val <= pointer.val && pointer.val <= q.val)
				return pointer;
			else if (p.val > pointer.val && q.val > pointer.val)
				pointer = pointer.right;
			else
				pointer = pointer.left;
		}
		return null;
	}
}
