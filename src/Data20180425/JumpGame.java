package Data20180425;

public class JumpGame {

    public boolean canJump(int[] nums){
        if(nums.length == 0)
            return true;

        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max) return false;
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

}
