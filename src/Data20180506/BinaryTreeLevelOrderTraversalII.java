package Data20180506;

import DataType.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(root, res, 0);
        return res;
    }

    public void DFS(TreeNode root, List<List<Integer>> res, int level){
        if(root == null)
            return;
        if(level >= res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        DFS(root.left, res, level + 1);
        DFS(root.right, res, level + 1);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }

}
