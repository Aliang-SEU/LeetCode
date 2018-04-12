import java.util.Queue;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

//03 Longest Substring Without Repeating Characters
public class Code01 {
	/*Solution1 Time complexity
	 	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Code01 ob = new Code01();
		System.out.println(ob.lengthOfLongestSubstring(str));
	}
	
	public int lengthOfLongestSubstring(String s) {
		int length=0;
		for(int i=0; i<s.length(); ++i)
			for(int j=i+1;j<=s.length();++j){
				if(allUnique(s,i,j)){
					length = Math.max(length, j-i);
				}
			}
		return length;
    }
	public boolean allUnique(String s, int i, int j){
		Set<Character> set = new HashSet<Character>();
		for(int itor=i; itor<j; itor++){
			Character ch = s.charAt(itor);
			if(set.contains(ch)) return false;
			else 
				set.add(ch);
		}
		return true;
	}*/
	//Solution2
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Code01 ob = new Code01();
		System.out.println(ob.lengthOfLongestSubstring(str));
	}
    /*public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
        	if(n-i <ans) break;
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }*/
	/*public int lengthOfLongestSubstring(String s) {
		int length=0;
		Set<Character> set = new HashSet<Character>();
		int n = s.length();
		for(int i=0; i<n; ++i){
			for(int j=i; j<n; ++j){
				if(set.contains(s.charAt(j))){
					set.clear();
					break;
				}
				else{
					set.add(s.charAt(j));
					length=Math.max(length,set.size());
				}
			}
		}
		return length;
	}*/
	public int lengthOfLongestSubstring(String s){
		int n = s.length(),ans = 0;
		Map<Character,Integer> map = new HashMap<>();
		for(int j=0, i=0; j<n; ++j){
			if(map.containsKey(s.charAt(j))){
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j-i+1);
			map.put(s.charAt(j),i+1);
		}
		return ans;
	}
	
	
}
