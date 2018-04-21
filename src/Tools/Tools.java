package Tools;

import DataType.TreeNode;

public class Tools {
	public static void printBinaryTreeInPreOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.val + " ");
			printBinaryTreeInPreOrder(root.left);
			printBinaryTreeInPreOrder(root.right);
		}
	}
	
	public static void printBinaryTreeInInOrder(TreeNode root) {
		if(root != null) {
			printBinaryTreeInInOrder(root.left);
			System.out.print(root.val + " ");
			printBinaryTreeInInOrder(root.right);
		}
	}
	
	public static void printBinaryTreeInPostOrder(TreeNode root) {
		if(root != null) {
			printBinaryTreeInPostOrder(root.left);
			printBinaryTreeInPostOrder(root.right);
			System.out.print(root.val + " ");
		}
	}
}
