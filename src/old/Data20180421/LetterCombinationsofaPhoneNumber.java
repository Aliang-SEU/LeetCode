package old.Data20180421;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args){
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("234"));

    }

    public List<String> letterCombinations(String digits){

        if(digits.length() == 0)
            return new ArrayList<String>();

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();


        int range = 3;
        int start = 0;
        if (digits.charAt(0) == '7' || digits.charAt(0) == '9') {
            range = 4;
        }

        for (int j = 0; j < range; j++) {
            char ch ='0';
            if (digits.charAt(0) <= '7')
                ch = (char) ((digits.charAt(0) - '2') * 3 + j + 'a');
            else if(digits.charAt(0) == '8')
                ch = (char) (19 + j + 'a');
            else if(digits.charAt(0) == '9')
                ch = (char) (22 + j + 'a');
            sb.append(ch);
            dfs(digits, 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return res;
    }
    public void dfs(String digits, int start, List<String> res, StringBuilder sb){
        if(start == digits.length()) {
            res.add(new String(sb));
            return;
        }

        int i = start;
            int range = 3;
            if (digits.charAt(i) == '7' || digits.charAt(i) == '9')
                range = 4;
            for (int j = 0; j < range; j++) {
                char ch ='0';
                if (digits.charAt(i) <= '7')
                    ch = (char) ((digits.charAt(i) - '2') * 3 + j + 'a');
                else if(digits.charAt(i) == '8')
                    ch = (char) (19 + j + 'a');
                else
                    ch = (char) (22 + j + 'a');
                sb.append(ch);
                dfs(digits, i + 1, res, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
    }

}
