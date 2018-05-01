package Data20180501;

public class AddBinary {
    public static void main(String[] args){
        System.out.println(new AddBinary().addBinary("1010", "1011"));

    }
    public String addBinary(String a, String b){
        if(a == null || a.length() == 0)
            return b;
        if(b == null || b.length() == 0)
            return a;
        int len = Math.min(a.length(), b.length());
        StringBuilder sb = new StringBuilder();

        int carryIn = 0;
        for(int i = 0; i < len; i++){
            int a1 = a.charAt(a.length() - 1 - i) - '0';
            int a2 = b.charAt(b.length() - 1 - i) - '0';
            int sum = a1 + a2 + carryIn;
            if(sum >= 2){
                carryIn = 1;
                sb.append((char)(sum % 2 + '0'));
            }else{
                carryIn = 0;
                sb.append((char)(sum + '0'));
            }
        }
        if(a.length() > len){
            for(int i = len; i < a.length(); i++){
                int a1 = a.charAt(a.length() - 1 - i) - '0';
                int sum = carryIn + a1;
                if(sum >= 2){
                    carryIn = 1;
                    sb.append((char)(sum % 2 + '0'));
                }else{
                    carryIn = 0;
                    sb.append((char)(sum + '0'));
                }
            }
        }else{
            for(int i = len; i < b.length(); i++){
                int a1 = b.charAt(b.length() - 1 - i) - '0';
                int sum = carryIn + a1;
                if(sum >= 2){
                    carryIn = 1;
                    sb.append((char)(sum % 2 + '0'));
                }else{
                    carryIn = 0;
                    sb.append((char)(sum + '0'));
                }
            }
        }
        if(carryIn == 1)
            sb.append('1');
        return sb.reverse().toString();
    }
}
