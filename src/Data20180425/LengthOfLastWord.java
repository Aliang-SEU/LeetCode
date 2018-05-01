package Data20180425;

public class LengthOfLastWord {
    public static void main(String[] args){
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World "));
    }
    public int lengthOfLastWord(String s){
        int idx = s.trim().lastIndexOf(" ");
        return s.length() - idx - 1;
    }
}
