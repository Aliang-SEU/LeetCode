package Data20180408;

public class ValidPalindrome {
	
	public static void main(String[] args) {
		isPalindrome("1a2");
	}
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char ch = s.charAt(left);

            while(left < right && !(ch>='0' && ch<='9' || ch>='A' && ch<='Z'  ||  ch>='a' && ch<='z')){
                ch = s.charAt(++left); 
            }
            char leftChar = Character.toLowerCase(ch);
            ch = s.charAt(right);
            while(left < right && !(ch>='0' && ch<='9' || ch>='A' && ch<='Z'  ||  ch>='a' && ch<='z')){
                ch = s.charAt(--right); 
            }
            
            char rightChar = Character.toLowerCase(ch);
            if(left >= right)
                return true;
            if(leftChar == rightChar){
                left++;
                right--;
                continue;
            }else 
                return false;
        }
        return true;
    }
}
