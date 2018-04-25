package Data20180424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 */
public class CombinationSum {

    public static void main(String[] args){
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7));

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, res, 0, new ArrayList<>(), target);
        return res;

    }
    public void dfs(int[] candidates, List<List<Integer>> res, int start, List<Integer> list, int target){
        if(target < 0)
            return;
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if (target - candidates[i] < 0) return;
            list.add(candidates[i]);
            dfs(candidates, res, i, list, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }

}
