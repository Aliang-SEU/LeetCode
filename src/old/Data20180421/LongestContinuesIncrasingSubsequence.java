package old.Data20180421;

/**
 * 寻找数组中最大的递增子序列的长度
 */
public class LongestContinuesIncrasingSubsequence {

    public static void main(String[] args){
        System.out.print(findLengthOfCIS(new int[]{1,3,5,4,7}));
    }
    public static int findLengthOfCIS(int[] nums){
        if(nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;
        }
        int max = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > max)
                max = dp[i];
        }
        return max;
    }

}
