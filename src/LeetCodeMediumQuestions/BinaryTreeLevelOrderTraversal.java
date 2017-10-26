package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sravan
 * created on Aug 7, 2017
 *
 */

/* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 *
 */

 
public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> binaryTreeOrderTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        
        while(q.size() != 0) {
            List<Integer> resList = new ArrayList<>();
            List<TreeNode> temp = new ArrayList<>();
            for(int i=0; i < q.size(); i++) {
                TreeNode currNode = q.get(i);
                resList.add(currNode.val);
                if(currNode.left != null)
                    temp.add(currNode.left);
                if(currNode.right != null)
                    temp.add(currNode.right);
            }
            res.add(resList);
            if(temp != null)
                q = new ArrayList<TreeNode>(temp);
        }
        return res;
	}

}
