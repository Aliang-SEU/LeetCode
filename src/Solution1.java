import java.util.HashSet;
import java.util.Set;
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        Set<Character>  _set = new HashSet<Character>();
        for(int i = 0; i < s.length(); ++i){
            if(!_set.contains(s.charAt(i))){
            	_set.add(s.charAt(i));
            	length++;
            }else{
            	_set.clear();
            }
        }
        return length;
    }
}