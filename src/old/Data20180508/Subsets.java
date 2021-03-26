package old.Data20180508;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.Subsets
 */
public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        dfs(nums, 0, res, new ArrayList<>());
        res.add(new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        if (start == nums.length)
            return;
        else {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                res.add(new ArrayList<>(list));
                dfs(nums, i + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
