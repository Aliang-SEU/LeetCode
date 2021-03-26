package old.Data20180427;

import old.DataType.TreeNode;

import java.util.LinkedList;

public class SubTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(8);
        root.left.right = new TreeNode(9);
        root.left.left = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(9);
        new SubTree().HasSubtree(root, root2);


    }
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root2 == null || root1 == null)
            return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(subTree(node, root2))
                    return true;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return false;
    }

    public boolean subTree(TreeNode root1, TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null && root2 != null)
            return false;
        if(root1.val != root2.val)
            return false;

        return subTree(root1.left, root2.left) && subTree(root1.right, root2.right);
    }
}
