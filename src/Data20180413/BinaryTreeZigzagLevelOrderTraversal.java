package Data20180413;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.naming.LimitExceededException;

import DataType.TreeNode;

/**
 * Zigza分层遍历
 * @author hzl
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.right.right = new TreeNode(5);
    	System.out.println(zigzagLevelOrder(root));
    	
    }
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null)
			return new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		
		int dir = 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		LinkedList<TreeNode> temp = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<>();		
			while(size-- > 0) {
				TreeNode node = queue.poll();
				temp.add(node);
			}
			size = temp.size();
			while(size-- > 0) {
				TreeNode node = temp.pollLast();
				list.add(node.val);
				if(dir == 0) {
					if(node.left != null)
						queue.offer(node.left);
					if(node.right != null)
						queue.offer(node.right);
				}
				else if(dir == 1) {
					if(node.right != null)
						queue.offer(node.right);
					if(node.left != null)
						queue.offer(node.left);
				}
			}
			res.add(list);
			dir = 1 - dir;
		}
		return res;
    }
}
