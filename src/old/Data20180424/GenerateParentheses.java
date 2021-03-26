package old.Data20180424;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *  For example, given n = 3, a solution set is:
 *
 *  [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 *  ]
 */
public class GenerateParentheses {

    public static void main(String[] args){
        System.out.print(new GenerateParentheses().generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        add(new StringBuilder(), res, 0, 0, n);
        return res;
    }
    public void add(StringBuilder sb, List<String> res, int cnt1, int cnt2, int n){
        if(cnt2 == n){
            res.add(new String(sb.toString()));
            return;
        }
        if(cnt1 < n) {
            StringBuilder s = new StringBuilder(sb);
            s.append('(');
            add(s, res, cnt1 + 1, cnt2, n);
        }
        if(cnt2 < cnt1) {
            StringBuilder s = new StringBuilder(sb);
            s.append(')');
            add(s, res, cnt1, cnt2 + 1, n);
        }
    }
}
