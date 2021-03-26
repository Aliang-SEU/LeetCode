package old.DefaultPackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Code7 {
	public static void main(String[] args) {
		String str = new String("aacd");
		ArrayList<String>  result1 = new Code7().Permutation(str);
		for(int i=0; i< result1.size(); ++i)
			System.out.println(result1.get(i));
	}
	ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
    	if(str.equals(""))
    		return result;
       char[] s = str.toCharArray();
       Arrays.sort(s);
       result.add(new String(str));
       Permutataion(s, 0, s.length);
       Collections.sort(result);
      return result;
    }
    public void Permutataion(char[] str, int start, int end) {
    	for(int i = start; i < end - 1; ++i) 
    		for(int j = i + 1; j < end; ++j) {
	    		if(str[i] != str[j]) {
	    			swap(str, i, j);
	    			result.add(new String(str));
	    			Permutataion(str, i + 1, end);
	    			swap(str, i, j);
	    		}
    	}
    }
    public void swap(char[] str, int i, int j) {
    	char temp = str[i];
    	str[i] = str[j];
    	str[j] = temp;
    }

}
