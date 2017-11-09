package LeetCodeMediumQuestions;

public class CountNodesCompleteBinaryTree {
	public int countNodes(TreeNode root) {
		if(root == null)
			return 0;
    
	    int left = getHeight(root, 1);
	    int right = getHeight(root, -1);
	    
	    if(left == right)
	        return (2<<left-1) - 1;
	    else
	        return 1 + countNodes(root.left) + countNodes(root.right);
	}
    
	private int getHeight(TreeNode root, int dir) {
        if(root == null)
            return 0;
        
        int height = 0;
        while(root != null) {
            root = dir == 1 ? root.left : root.right;
            height++;
        }
        return height;
    }
}
