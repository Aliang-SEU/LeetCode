package Data20180508;

import java.util.ArrayList;
import java.util.List;

/**
 * 77.Combinations
 */
public class Combinations {

    public static void main(String[] args){
        System.out.print(new Combinations().combine(4, 2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < 1 || k < 1)
            return res;

        dfs(n, k, 1, res, new ArrayList<>());
        return res;
    }

    public void dfs(int n, int k, int start, List<List<Integer>> res, List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
        }
        if(start > n)
            return;
        else{
            for(int i = start; i <= n; i++){
                list.add(i);
                dfs(n, k, i + 1 , res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
