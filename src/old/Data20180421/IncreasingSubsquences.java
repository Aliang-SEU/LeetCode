package old.Data20180421;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 寻找数组中所有的递增子序列
 */
public class IncreasingSubsquences {

    public static void main(String[] args){
        System.out.print(new IncreasingSubsquences().findSubSquences(new int[]{4,6,7,7}));

    }


    public List<List<Integer>> findSubSquences(int[] nums){
        Set<List<Integer>> res = new HashSet<>();
        if(nums.length == 0)
            return  new ArrayList<>();;

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length - 1; i++){
            list.add(nums[i]);
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] >= list.get(list.size() - 1)) {
                    list.add(nums[j]);
                    res.add(new ArrayList<>(list));
                    dfs(nums,j + 1, res, list);
                    list.remove(list.size() - 1);
                }
            }
            list.remove(list.size() - 1);
        }
        return new ArrayList<List<Integer>>(res);
    }
    public void dfs(int[] nums, int start, Set<List<Integer>> res, List<Integer> list){
        if (start == nums.length)
            return;
        for (int j = start; j < nums.length; j++) {
            if (nums[j] >= list.get(list.size() - 1)) {
                list.add(nums[j]);
                res.add(new ArrayList<>(list));
                dfs(nums, j + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
