package old.DefaultPackage;
import java.util.Stack;

public class MirroOfBinaryTree {
	
	public void Mirror(TreeNode root) {
		if(root == null)
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = right;
		root.right = left;
		Mirror(left);
		Mirror(right);
	}
	public void Mirror1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.left != null || node.right != null ) {
				TreeNode temp = node.left;
				node.left = node.right;
				node.right = temp;
			}
			if(node.left != null)
				stack.push(node.left);
			if(node.right != null)
				stack.push(node.right);
		}
		
	}
}
