package old.Data20180421;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 */
public class Sum4 {
    public static void main(String[] args){
        System.out.print(new Sum4().fourSum(new int[]{-1,-5,-5,-3,2,5,0,4}, -7));

    }
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)
            return res;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){

            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)break;
            if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target)continue;
            if(i > 1 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < nums.length - 2; j++){
                if(j >= i + 1 && nums[j] == nums[j - 1])
                    continue;

                int minValue = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if(minValue > target)
                    break;
                int m = j + 1;
                int n = nums.length - 1;
                while(m < n){
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        res.add(list);
                        m ++;
                        n --;
                        while(m < n && nums[m] == nums[m - 1])
                            m ++;
                        while(m < n && nums[n] == nums[n + 1])
                            n --;
                    }else if(sum > target){
                        n --;
                        while(m < n && nums[n] == nums[n + 1])
                            n --;
                    }
                    else{
                        m ++;
                        while(m < n && nums[m] == nums[m - 1])
                            m ++;
                    }
                }
            }
        }
        return res;
    }
}
