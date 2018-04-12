package DefaultPackage;

public class Code10 {
	TreeNode root = new TreeNode(5);
	private class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	Code10(){
    	root.left = new TreeNode(3);
    	root.right = new TreeNode(6);
    	root.left.left = new TreeNode(2);
    	root.left.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(4);
    }
    private int maxDepth = 0;
    public static void main(String[] args) {
    	Code10 c = new Code10();
    	boolean result = c.IsBalanced_Solution(c.root);
    	System.out.print(result);
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        boolean result = searchDepth(root, 0);
        return result;
    }
    public boolean searchDepth(TreeNode root, int depth){
        if(root == null){
            if(depth >= maxDepth && maxDepth == 0)
                maxDepth = depth;
            if(Math.abs(depth - maxDepth) <=1)
                return true;
            else
                return false; 
        }else{
            depth++;
            boolean left = searchDepth(root.left, depth);
            boolean right = searchDepth(root.right, depth);
            return (left && right);
        }
    }
}
