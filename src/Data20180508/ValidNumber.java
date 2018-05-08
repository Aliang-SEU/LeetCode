package Data20180508;

public class ValidNumber {

    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if('0' <= ch && ch <= '9'){
                numberSeen = true;
                numberAfterE = true;
            }else if(ch == '.'){
                if(eSeen || pointSeen)
                    return false;
                pointSeen = true;
            }else if(ch == 'e'){
                if(eSeen || !numberSeen)
                    return false;
                numberAfterE = false;
                eSeen = true;
            }else if(ch == '-' || ch == '+'){
                if(i != 0 && s.charAt(i - 1) != 'e'){
                    return false;
                }
            }else
                return false;
        }
        return numberSeen && numberAfterE;
    }
}
