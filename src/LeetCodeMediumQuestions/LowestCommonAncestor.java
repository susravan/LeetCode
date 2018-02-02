package LeetCodeMediumQuestions;

public class LowestCommonAncestor {
	public TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return getCA(root, p, q);
	}
	
	// Approach: Recursive solution
	// Looking at the problem, we can see that it can be solved recursively.
	// Given a root, either it can be our CA or it can exist to its left side or right side
	// Call on left side, if found, return it. Similarly right
	// But if no ancestor is found in one branch, we need some value to communicate with its parents for which we return NULL.
	// If both null, 
	private TreeNode getCA(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		
		if(root == p || root == q)
			return root;
		
		TreeNode leftCA = getCA(root.left, p, q);
		TreeNode rightCA = getCA(root.right, p, q);
		
		if(leftCA == null && rightCA == null)
			return null;
		if(leftCA == null)
			return rightCA;
		if(rightCA == null)
			return leftCA;
		
		return root;
	}
}
