package old.Data20180506;

import old.DataType.TreeNode;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return (int)Math.max(left, right) + 1;
    }

}
