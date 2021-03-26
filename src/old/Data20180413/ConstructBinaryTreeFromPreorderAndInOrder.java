package old.Data20180413;

import java.util.ArrayList;

import old.DataType.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0)
            return null;
        ArrayList<Integer> target = new ArrayList<>();
        target.add(-1);
        return tree(inorder, 0, inorder.length - 1, preorder, target);
    }
    public TreeNode tree(int[] order, int left, int right, int[] postorder, ArrayList<Integer> target){
        if(left > right || target.get(0) == postorder.length - 1)
        	return null;
        target.set(0, target.get(0) + 1);
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
        root.left = tree(order, left, i - 1, postorder, target);
        root.right = tree(order, i + 1, right, postorder, target);
        return root;
    }
}
