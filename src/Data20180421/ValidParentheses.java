package Data20180421;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 */
public class ValidParentheses {
    public static void main(String[] args){
        System.out.print(new ValidParentheses().isValid("()"));

    }
    public boolean isValid(String s){
        if(s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else{
                if(stack.isEmpty())
                    return false;
                char ch = stack.pop();
                if((ch == '(' && s.charAt(i) != ')' ) ||
                        (ch == '{' && s.charAt(i) != '}' )||
                        (ch == '[' && s.charAt(i) != ']' ))
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return  false;
    }

}
