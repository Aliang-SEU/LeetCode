package old.Data20180425;

import java.util.*;

public class PermutationsII {
    public static void main(String[] args){
        System.out.println(new PermutationsII().permuteUnique2(new int[]{1,1,2}));
    }
    public List<List<Integer>> permuteUnique1(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        res.add(list);
        for(int i = 1; i < nums.length; i++){
            int size = res.size();
            for(int j = 0; j < size; j++){
                List<Integer> temp = res.get(0);
                int pos = temp.lastIndexOf(nums[i]) + 1;
                for(int k = pos; k <= temp.size(); k++){
                    List<Integer> li = new ArrayList<>(temp);
                    li.add(k, nums[i]);
                    res.add(li);
                }
                res.remove(0);
            }
        }
        return res;
    }
    public List<List<Integer>> permuteUnique2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        dfs(nums, res, new ArrayList<>(), used);
        return new ArrayList<List<Integer>>(res);
    }
    public void dfs(int[] nums, List<List<Integer>>  res, List<Integer> list, int[] used){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] == 1 || i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) continue;
            list.add(nums[i]);
            used[i] = 1;
            dfs(nums, res, list, used);
            list.remove(list.size() - 1);
            used[i] = 0;
        }
    }
}
