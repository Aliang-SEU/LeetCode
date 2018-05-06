package Data20180506;

import DataType.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args){
        new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = toBST(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode toBST(int[] nums, int i, int j){
        if(i > j || nums.length == 0)
            return null;
        else{
            int mid = i + (j - i + 1) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = toBST(nums, i, mid - 1);
            root.right = toBST(nums, mid + 1, j);
            return root;
        }
    }
}
