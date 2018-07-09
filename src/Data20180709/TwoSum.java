package Data20180709;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        Arrays.sort(numbers);
        int l = 0, r = numbers.length - 1;
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum < target){
                l++;
            }else if(sum > target){
                r--;
            }else{
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            }
        }
        return result;
    }
}
