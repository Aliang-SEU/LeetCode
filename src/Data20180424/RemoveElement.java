package Data20180424;

/**
 * 27. Remove Element
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val){
        if(nums.length == 0)
            return 0;

        int len = 0;
        int idx = 0;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num == val){
                continue;
            }else{
                nums[idx++] = num;
                len++;
            }
        }
        return len;
    }
}
