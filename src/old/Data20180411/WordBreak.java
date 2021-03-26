package old.Data20180411;

import java.util.*;


public class WordBreak {
	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak(s, dict));
		
	}
    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; dp[i] == true && j <= s.length(); j++){
            	String str = s.substring(i, j);
                if(dict.contains(str))
                    dp[j] = true;
            }
        }
        return dp[s.length()];
    }
}
