package Data20180411;

import java.util.ArrayList;

public class PalindromePartitioning {
	public static void main(String[] args) {
		String s = "aab";
		ArrayList<ArrayList<String>> res = new PalindromePartitioning().partition(s);
		System.out.println(res);
	}
    public ArrayList<ArrayList<String>> partition(String s) {
    	 ArrayList<String> path =  new ArrayList<>();
    	 ArrayList<ArrayList<String>> list = new ArrayList<>();
    	 dfs(s, path, list);
    	 return list;
    }
    @SuppressWarnings("unchecked")
	public void dfs(String s, ArrayList<String> path, ArrayList<ArrayList<String>> list) {
     	if(s.length() < 1) {
    		list.add((ArrayList<String>)path.clone());
    		return;
    	}
    	for(int i = 0; i < s.length(); i++) {
    		int start = 0;
    		int end = i;
    		while(start < end) {
    			if(s.charAt(start) == s.charAt(end)) {
    				start++;
    				end--;
    			}else 
    				break;
    		}
    		if(start >= end) {
    			path.add(s.substring(0, i + 1));
    			dfs(s.substring(i + 1), path, list);
    			path.remove(path.size() - 1);
    		}
    	}
    } 
}
