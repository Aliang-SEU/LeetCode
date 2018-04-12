package DefaultPackage;
import java.util.ArrayList;

public class Code06 {
	
	TreeNode root = new TreeNode(10);
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    Code06(){
    	root.left = new TreeNode(5);
    	root.right = new TreeNode(12);
    	root.right.left = new TreeNode(11);
    	root.right.right = new TreeNode(13);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(7);
    }
    public static void main(String[] args) {
    	Code06 c = new Code06();
    	TreeNode node = c.Convert(c.root);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(pRootOfTree);
        convert(list, 0);
        for(int i=0; i<list.size() - 1; ++i){
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        list.get(0).left = list.get(list.size()-1);
        return list.get(0);
    }
    public int convert(ArrayList<TreeNode> list, int i){
    	TreeNode node = list.get(i);
        if(node.left != null){
            list.add(i, node.left);
            i = convert(list, i);
            i++;
        }
        if(node.right != null){
            list.add(i+1, node.right);
            i = convert(list, i+1);
        }
        return i;
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
            return result;
        
        findPath(new ArrayList<Integer>(), root, target);
        return result;
    }
    public void findPath(ArrayList<Integer> list, TreeNode root, int target){
        if(target == 0)
            result.add(list);
        if(root.val > target)
            return;
        list.add(root.val);
        if(root.left != null)
            findPath(new ArrayList<Integer>(list), root.left, target - root.val);
        if(root.right != null)
            findPath(new ArrayList<Integer>(list), root.right, target - root.val);
    }
	
	private class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
}
