package Data20180506;

import DataType.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        pathSum(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && root.val == sum) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        pathSum(root.left, sum - root.val, list, res);
        pathSum(root.right, sum - root.val, list, res);
        list.remove(list.size() - 1);
    }
}
