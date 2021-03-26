package old.Data20180424;

/**
 * 38. Count and Say
 */
public class CountAndSay {
    public static void main(String[] args){
        new CountAndSay().countAndSay(5);
    }
    public String countAndSay(int n){
        if(n == 1)
            return "1";
        String s = "1";
        for(int i = 2; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            int start = 0;
            for(int j = 0; j < s.length();){
                while(j < s.length() &&
                        s.charAt(j) == s.charAt(start)){
                    j++;
                };
                sb.append(j - start);
                sb.append(s.charAt(start));
                start = j;
            }
            s = sb.toString();
        }
        return s;
    }
}
