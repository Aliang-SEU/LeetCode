package old.Data20180506;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args){
        int[] a = new int[]{0,1,1,0,2,1,0};
        new SortColors().sortColors(a);
        System.out.println(Arrays.toString(a));
    }

    public void sortColors(int[] nums) {
        int start = 0, i = 0, j = nums.length - 1;
        while(i <= j){
            while(i <= j && nums[i] == 1) i++;
            if(i > j) break;
            if(nums[i] < 1){
                swap(nums, i++ , start++);
            }else if(nums[i] > 1)
                swap(nums, i, j--);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
