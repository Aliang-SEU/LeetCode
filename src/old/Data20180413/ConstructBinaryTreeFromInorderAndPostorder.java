package old.Data20180413;

import java.util.ArrayList;

import old.DataType.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorder {
	
	public static void main(String[] args) {
		int[] inorder = {4,2,5,1,6,3,7};
		int[] postorder = {4,5,2,6,7,3,1};
		TreeNode root = new ConstructBinaryTreeFromInorderAndPostorder().buildTree(inorder, postorder);
		old.Tools.Tools.printBinaryTreeInInOrder(root);
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        ArrayList<Integer> target = new ArrayList<>();
        target.add(postorder.length);
        return tree(inorder, 0, inorder.length - 1, postorder, target);
    }
    public TreeNode tree(int[] order, int left, int right, int[] postorder, ArrayList<Integer> target){
        if(left > right || target.get(0) == 0)
        	return null;
        target.set(0, target.get(0) - 1);
    	if(left == right && order[left] == postorder[target.get(0)]){
            return new TreeNode(postorder[target.get(0)]);
        }
        int i = 0;
        for(i = left; i <= right; i++){
            if(order[i] == postorder[target.get(0)]){
                break;
            }
        }

        TreeNode root = new TreeNode(postorder[target.get(0)]);
        root.right = tree(order, i + 1, right, postorder, target);
        root.left = tree(order, left, i - 1, postorder, target);

        return root;
    }
}
