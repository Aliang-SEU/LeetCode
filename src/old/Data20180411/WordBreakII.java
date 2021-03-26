package old.Data20180411;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
	   ArrayList<String> list = new ArrayList<>();
	   public static void main(String[] args) {

		   	String s = "catsanddog";
			Set<String> dict = new HashSet<String>();
			dict.add("cat");
			dict.add("cats");
			dict.add("and");
			dict.add("sand");
			dict.add("dog");
			long ss = System.currentTimeMillis();
			ArrayList<String>  list = new WordBreakII().wordBreak2(s, dict);
			System.out.println(System.currentTimeMillis() - ss);
			ss = System.currentTimeMillis();
			list = new WordBreakII().wordBreak(s, dict);
			System.out.println(System.currentTimeMillis() - ss);
			
			
			for(String s1 : list) {
				System.out.println(s1);
			}
	   }
		       public ArrayList<String> wordBreak(String s, Set<String> wordDict) {
			   	return DFS(s, wordDict, new HashMap<String, ArrayList<String>>());
			   	}

		   private ArrayList<String> DFS(String s, Set<String> wordDict, HashMap<String, ArrayList<String>> map) {
		           if (map.containsKey(s))
		               return map.get(s);
		           ArrayList<String> res = new ArrayList<String>();
		           if (s.length() == 0){
		               res.add("");
		               return res;
		           }
		           for (String subStr : wordDict) {
		               if (s.startsWith(subStr)) {
		                   for (String str : DFS(s.substring(subStr.length()), wordDict, map)) {
		                       res.add(subStr + (str == "" ? "" : " ")+ str);
		    
		                   }
		    
		               }
		           }
		           map.put(s, res);
		           return res;
		    
		       }
	   
	   public ArrayList<String> wordBreak2(String s, Set<String> dict) {
	       if(s.length() == 0)
	           return list;
	       boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
	       dp[0][0] = true;
	       for(int i = 0; i < s.length(); i++){
	           for(int j = 0; j <= i; j++){
	               if(dp[j][i] == true){
	                   for(int k = i + 1; k <= s.length(); k++){
	                       String str = s.substring(i, k);
	                       if(dict.contains(str)){
	                           dp[i][k] = true;
	                       }
	                   }
	               }
	           }
	       }
	       for(int i = 1; i < s.length(); i++){
	           if(dp[0][i] == true){
	               StringBuilder tempSb = new StringBuilder();
	                tempSb.append(s.substring(0, i));
	                addString(tempSb, dp, s, i);
	           }
	       }
	       return list;
	    }
	    private void addString(StringBuilder sb, boolean[][] dp, String s, int start){
	        if(start == s.length()){
	            list.add(sb.toString());
	            return;
	        }
	        for(int i = start + 1; i <= s.length(); i++){
	            if(dp[start][i] == true){
	                StringBuilder tempSb = new StringBuilder(sb);
	                tempSb.append(' ' + s.substring(start, i));
	                addString(tempSb, dp, s, i);
	            }
	        }
	    }
}
