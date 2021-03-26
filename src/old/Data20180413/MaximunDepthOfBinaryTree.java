package old.Data20180413;

import java.util.LinkedList;

import old.DataType.TreeNode;

public class MaximunDepthOfBinaryTree {
	
	public int maxDepthWithQueue(TreeNode root) {
		if(root == null)
			return 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int maxDepth = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			maxDepth++;
			while(size-- > 0) {
				TreeNode node = queue.poll();
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
		}
		return maxDepth;
	}
	public int maxDepth(TreeNode root) {
		return depth(root);
	}
	
	public int depth(TreeNode root) {
		if(root == null)
			return 0;
		
		int left = depth(root.left);
		int right = depth(root.right);
		
		int depth = Math.max(left, right);
		
		return depth + 1;
	}
}
