package Data20180628;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMinNum {

    public static void main(String[] args){
        int[] num = new int[]{3,4,5,6,1,2};

        System.out.println(new FindMinNum().findMin(num));

    }

    public int findMin(int[] nums){
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        if(nums[end] > nums[start]) {
            return nums[start];
        }
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[start]){
                start = mid;
            }else if(nums[mid] < nums[start]){
                end = mid;
            }else {
                start = end;
            }
        }
        return nums[start];
    }
}
