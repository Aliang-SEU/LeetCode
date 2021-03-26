package old.Data20180408;

import java.util.ArrayList;
import java.util.LinkedList;

import old.DataType.TreeNode;

public class BinaryTreePreorderTraversal {
	
	/**
	 * 二叉树的先序遍历(迭代)
	 * @param root
	 * @return
	 */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> list = new ArrayList<>();
    	if(root == null)
    		return list;
    	LinkedList<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		while(size-- > 0) {
    			TreeNode node = queue.poll();
    			list.add(node.val);
    			if(node.right != null)
    				queue.offerFirst(node.right);
    			if(node.left != null) {
    				queue.offerFirst(node.left);
    			}
    		}
    	}
    	return list;
    }
    /**
     * 二叉树的先序遍历(递归)
     */
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> preorderTraversal1(TreeNode root){
    	preorder(root);
    	return list;
    }
    public void preorder(TreeNode root) {
    	if(root == null)
    		return;
    	list.add(root.val);
    	preorder(root.left);
    	preorder(root.right);
    }
}
