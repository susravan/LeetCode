package LeetCodeEasyQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	// Recursive Solution
	public boolean isSymmetricRecur(TreeNode root) {
		if(root == null)
			return true;
		
		return isSymmetricRecurHelper(root.left, root.right);
	}
	
	private boolean isSymmetricRecurHelper(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.val == root2.val)
			return isSymmetricRecurHelper(root1.left, root2.right) && isSymmetricRecurHelper(root1.right, root2.left);
		else
			return false;
	}
	
	// Iterative Solution
	public boolean isSymmetricIter(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        
        while(!q.isEmpty()) {
            // Since the queue is not empty, we can use remove. Removing the second time, we should ise poll as the queue may be empty in case of any bugs
            TreeNode node1 = q.remove();
            TreeNode node2 = q.poll();
            if(node1 == null && node2 == null)
                continue;
            if(node1 == null || node2 == null)
                return false;
            if(node1.val != node2.val)
                return false;
            
            if(node1.val == node2.val) {
                q.add(node1.left);
                q.add(node2.right);
                q.add(node1.right);
                q.add(node2.left);
            }
        }
        return true;
	}
}
