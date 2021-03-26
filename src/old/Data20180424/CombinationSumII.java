package old.Data20180424;

import java.util.*;

/**
 * 40. Combination Sum II
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();
        dfs(candidates, res, 0, new ArrayList<>(), target);
        return new ArrayList<>(res);

    }
    public void dfs(int[] candidates, Set<List<Integer>> res, int start, List<Integer> list, int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if (i != start && candidates[i] == candidates[i-1])
                continue;
            if (target - candidates[i] < 0) return;
            list.add(candidates[i]);
            dfs(candidates, res, i + 1, list, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }

}
