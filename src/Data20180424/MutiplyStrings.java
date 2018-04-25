package Data20180424;

public class MutiplyStrings {

    public static void main(String[] args){
        System.out.print(new MutiplyStrings().multiply("91", "9"));

    }
    public String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int[] res = new int[num1.length() + num2.length()];

        for(int i = 0; i < num1.length(); i++){
            for(int j = 0;j < num2.length(); j++){
                res[1 + i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        //从低到高依次进位
        int carryIn = 0;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] += carryIn;
            carryIn = res[i] / 10;
            res[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++){
            if(i == 0 && res[i] == 0)
                continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
