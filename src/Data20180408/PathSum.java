package Data20180408;

import DataType.TreeNode;

public class PathSum {
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	int curSum = 0;
    	if(root == null)
    		return false;
    	return calcSum(root, curSum, sum);
    }
    
    public static boolean calcSum(TreeNode root, int curSum, int sum) {
        if(root == null)
            return false;
        curSum += root.val;
        if(root.left == null && root.right == null) {
            if(sum == curSum)
    			return true;
    		else
    			return false;
    	}
    	return calcSum(root.left, curSum, sum) || calcSum(root.right, curSum, sum);
    		
    }
    
}
