package old.Data20180709;

public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int l = 0, r = nums.length - 1;
        if(nums[l] > nums[r]){
            while(l < r - 1){
                int m = l + (r - l) / 2;
                if(nums[l] < nums[m]){
                    l = m;
                }else{
                    r = m;
                }
            }
        }
        return Math.min(nums[l], nums[r]);
    }
}
