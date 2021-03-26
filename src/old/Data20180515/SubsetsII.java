package old.Data20180515;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args){
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        dfs(nums, 0, res, new ArrayList<>());
        res.add(new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int start, List res, List list){
        if(start == nums.length)
            return;
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i - 1])
                    continue;
                list.add(nums[i]);
                res.add(new ArrayList<Integer>(list));
                dfs(nums, i + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
