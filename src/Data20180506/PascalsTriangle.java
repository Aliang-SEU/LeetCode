package Data20180506;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args){
        System.out.println(new PascalsTriangle().generate(5));

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0)
            return res;

        int[] nums = new int[numRows];
        nums[0] = 1;
        for(int i = 1; i <= numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = i - 1; j >= 1; j--){
                nums[j] = nums[j] + nums[j - 1];
            }
            for(int j = 0; j < i; j++){
                list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }

}
