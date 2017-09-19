package LeetCodeEasyQuestions;

import tree.Node;
import tree.binaryTree;

public class EasyQuestionsMain {

	public static void main(String args[]) {
		
		//		 	 10
		//         /    \
		//        5	    15
		//		 / \    / \
		//		2   7  13 18
		//					\
		//					23
		//				   /  
		//				  22
		binaryTree tree = new binaryTree();
		tree.root = new Node(10);
		tree.root.parent = null;
		tree.root.left = new Node(5);
		tree.root.left.parent = tree.root;
		tree.root.right = new Node(15);
		tree.root.right.parent = tree.root;
		tree.root.left.left = new Node(2);
		tree.root.left.left.parent = tree.root.left;
		tree.root.left.right = new Node(7);
		tree.root.left.right.parent = tree.root.left;
		tree.root.right.left = new Node(13);
		tree.root.right.left.parent = tree.root.right;
		tree.root.right.right = new Node(18);
		tree.root.right.right.parent = tree.root.right;
		tree.root.right.right.right = new Node(23);
		tree.root.right.right.right.parent = tree.root.right.right;
		tree.root.right.right.right.left = new Node(22);
		tree.root.right.right.right.left.parent = tree.root.right.right.right;

//		binaryTree tree2 = new binaryTree();
//		tree2.root = new Node(10);
//		tree2.root.parent = null;
//		tree2.root.left = new Node(5);
//		tree2.root.left.parent = tree2.root;
//		tree2.root.right = new Node(15);
//		tree2.root.right.parent = tree2.root;
//		tree2.root.left.left = new Node(2);
//		tree2.root.left.left.parent = tree2.root.left;
//		tree2.root.left.right = new Node(7);
//		tree2.root.left.right.parent = tree2.root.left;
//		tree2.root.right.left = new Node(13);
//		
//		System.out.println("Testing mergeTrees method");
//		Node result = EasyQuestions.mergeTrees(tree.root, tree2.root);
//		System.out.println("After merging tree - ");
//		EasyQuestions.printTree(result);
		
		System.out.println(EasyQuestions.getLeftView(tree.root));
//		System.out.println("0x55555555 = " + Integer.toBinaryString(0x55555555));
//		System.out.println("0x33333333 = " + Integer.toBinaryString(0x33333333));
		
	}

}
