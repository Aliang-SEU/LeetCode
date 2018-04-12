package DefaultPackage;
import java.util.*;
public class Solution3 {
	public static void main(String[] args) {
		int[] a = new int[] {3,2,4};
		int[] b = new Solution3().twoSum(a, 6);
	}
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> num = new HashMap<Integer,Integer>();
        for(int i=0; i<numbers.length; ++i){
            num.put(numbers[i],i);
        }
        int[] result = new int[2];
        for(int i=0; i<numbers.length; ++i){
            if(num.containsKey(target - numbers[i]) && num.get(target - numbers[i]) != i){
                result[0] = i + 1;
                result[1] = num.get(target - numbers[i]) + 1;
                break;
            }
        }
        return result;
    }
}