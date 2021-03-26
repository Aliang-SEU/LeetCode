package old.Data20180508;

public class SearchinRotatedSortedArrayII {

    public static void main(String[] args) {
        System.out.println(new SearchinRotatedSortedArrayII().search(new int[]{1, 3, 1, 1, 1}, 3));
    }

    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return true;

            if(nums[mid] < nums[high]  || nums[mid] < nums[low]){
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else
                    high = mid - 1;
            }else if(nums[mid] > nums[low] || nums[mid] > nums[high]){
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }else{
                high--;
            }
        }
        return false;
    }
}
