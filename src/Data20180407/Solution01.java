package Data20180407;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * word-break-ii
 * @author hzl
 *
 */
public class Solution01 {
	
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<>();
		//dict.add("cat");dict.add("cats");dict.add("and");dict.add("sand");dict.add("dog");
		dict.add("aaaa");
		dict.add("aaa");
		System.out.println(wordBreak1("aaaaaaa", dict));
		ArrayList<String> a = new ArrayList<>();
		a.add("123");
	}
	   public static ArrayList<StringBuilder> wordBreak1(String s, Set<String> dict) {
	        ArrayList<StringBuilder> res = new ArrayList<>();
	        if(dict.contains(s))
	        	res.add(new StringBuilder(s));
	        for(int i = 1; i < s.length(); ++i) {
	        	String w = s.substring(i);
	        	if(!dict.contains(w))
	        		continue;
	        	String str = s.substring(0,i);
	        	 ArrayList<StringBuilder> left = wordBreak1(str, dict);
	        	 Add(left, w);
	        	 res.addAll(left);
	        }
	        return res;
	   }
	   
	   private static void Add(ArrayList<StringBuilder> left, String w) {
		   for(Iterator<StringBuilder> it = left.iterator(); it.hasNext();) {
			   StringBuilder s = it.next();
			   s = s.append(' ' + w);
		   }
	   }
	   public static ArrayList<String> wordBreak(String s, Set<String> dict) {
	        ArrayList<String> res = new ArrayList<>();
	    	LinkedList<Integer> queue = new LinkedList<>();
	    	for(int i = 0; i <= s.length(); ++i){
	    		String str = s.substring(0,i);
	            if(dict.contains(str)) {
	            	queue.offer(i);
	            }
	        }
	    	while(!queue.isEmpty()) {
	    		int pos = queue.pollLast();
	    		
	    		StringBuilder sb = new StringBuilder(s.substring(0,pos));
	    		for(int i = pos + 1; i <= s.length(); ++i) {
	    			String str = s.substring(pos,i);
	    			  if(dict.contains(str)) {
	    				  sb.append(' ' + str);
	    				  pos = i;
	    			  }
	    		}
	    		if(pos == s.length())
	    			res.add(sb.toString());
	    	}
	    	return res;
	    }
}