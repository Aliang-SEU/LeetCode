package Data20180408;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import DataType.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		ArrayList<ArrayList<Integer>> res = levelOrderBottom(root);
		System.out.println(res);
	}
	
	public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		
		if(root == null)
			return res;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<>();
			while(size-- > 0) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
			res.add(list);
		}
		Collections.reverse(res);
		return res;
	}
}

