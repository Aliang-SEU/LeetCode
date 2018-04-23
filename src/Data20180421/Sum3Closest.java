package Data20180421;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 */
public class Sum3Closest {

    public int threeSumClosest(int[] nums, int target){
         Arrays.sort(nums);
         int diff = Integer.MAX_VALUE;
         int result = 0;
         for(int i = 0; i < nums.length - 2; i++){
             int m = i + 1;
             int n = nums.length - 1;
             while(m < n) {
                 int temp = nums[i] + nums[m] + nums[n] - target;
                 if (temp == 0)
                     return target;
                 if (diff > Math.abs(temp)) {
                     diff = Math.abs(temp);
                     result = nums[i] + nums[m] + nums[n];
                 }
                 if (temp < 0) {
                     m++;
                 } else
                     n--;
             }
         }
         return result;
    }

}
