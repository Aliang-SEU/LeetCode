package Data20180420;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void  main(String[] args){
        String s = "aaaab";
        System.out.println(new PalindromePartitioning().partition(s));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.length() == 0)
            return res;
        List<String> list = new ArrayList<>();
        partition(s, 0, res, list);
        return res;
    }
    public void partition(String s, int start, List<List<String>> res, List<String> list){
        if(start == s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int j = start; j < s.length(); j++){
            if(isPalidrom(s, start, j)){
                list.add(s.substring(start, j + 1));
                partition(s, j + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isPalidrom(String s, int i, int j){
        int mid = i + (j - i) / 2;
        for(int idx = i; idx <= mid; idx++){
            if(s.charAt(idx) != s.charAt(j + i - idx))
                return false;
        }
        return true;
    }
}
