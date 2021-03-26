package old.Data20180411;

import old.DataType.TreeNode;

public class BinaryTreeMaximunPathSum {
	private int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		System.out.println(new BinaryTreeMaximunPathSum().maxPathSum(root));
	}
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        //当前点的最大值
        int cur = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
        if(cur > max)
            max = cur;
        return root.val + Math.max(left, Math.max(right, 0));
    } 
}
