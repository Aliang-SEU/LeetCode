package Data20180515;

import DataType.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTravelsal {

    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;
        while(node != null){
            stack.push(node);
            node = node.left;
            while(node == null && !stack.isEmpty()){
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }

        return res;
    }

}
