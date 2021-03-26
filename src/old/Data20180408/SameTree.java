package old.Data20180408;

import old.DataType.TreeNode;

public class SameTree {
    
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		else if(p == null || q == null)
			return false;
		else if(p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	
}
