package old.Data20180424;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama"is a palindrome.
 * "race a car"is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public static void main(String[] args){
        System.out.print(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s){
        if(s == null || s.length() == 0)
            return true;
        s = s.replaceAll("\\W", "");
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(i < j && !isAlpha(s.charAt(i))) i++;
            while(i < j && !isAlpha(s.charAt(j))) j--;
            if(i >= j)
                return true;
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    public boolean isAlpha(char s){
        if(s >= 'a' && s <= 'z' || s >= 'A' && s <= 'Z' || s >= '0' && s <= '9')
            return true;
        else
            return false;
    }
    public boolean isPalindrome1(String s){
        if(s == null || s.length() == 0)
            return true;

        int left = 0, right = s.length() - 1;
        return isSame(s, left, right);
    }

    public boolean isSame(String s, int left, int right){
        while(left < s.length() && !((s.charAt(left) >= 'a' && s.charAt(left) <= 'z') || (s.charAt(left) >= 'A' && s.charAt(left) <='Z'))){
            left++;
        }
        while(right >= 0 && !((s.charAt(right) >= 'a' && s.charAt(right) <= 'z') || (s.charAt(right) >= 'A' && s.charAt(right) <='Z'))){
            right--;
        }
        if(left >= right)
            return true;

        if(left <= right && s.substring(left, left + 1).toLowerCase().equals(s.substring(right, right + 1).toLowerCase())){
            return isSame(s, left + 1, right - 1);
        }
        return false;
    }
}
