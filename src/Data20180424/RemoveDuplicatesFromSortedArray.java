package Data20180424;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args){
        System.out.print(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

    }

    public int removeDuplicates(int[] nums){
        if(nums.length == 0)
            return 0;

        int length = 1;
        int value = nums[0];
        int idx = 0;
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            if(value == num)
                continue;
            else{
                value = num;
                nums[++idx] = value;
                length++;
            }
        }
        return length;
    }

    public int removeDuplicates1(int[] nums){
        int i = 0, j = 1;
        boolean flag = false;
        while(j < nums.length){
            if(nums[j] == nums[i]){
                j++;
                flag = true;
            }else if(nums[j] != nums[i]){
                if(flag == true){
                    nums[++i] = nums[j];
                    flag = false;
                }else{i++;j++;}

            }
        }
        return i + 1;
    }

}
