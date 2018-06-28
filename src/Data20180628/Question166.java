package Data20180628;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 */
public class Question166 {

    public static void main(String[] args) {

        System.out.println(new Question166().fractionToDecimal(-1,
                                                                  -2147483648));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if(numerator < 0 && denominator > 0
                || numerator > 0 && denominator < 0){
            sb.append('-');
            numerator *= -1;
        }

        int div = numerator / denominator;
        int mod = numerator % denominator;

        //整数部分
        sb.append(div);

        if (mod == 0) {
            return sb.toString();
        } else {
            sb.append('.');
            Map<Integer, Integer> firstMod = new HashMap<>();

            int bit = 0;
            StringBuilder modString = new StringBuilder();
            firstMod.put(mod, bit);
            while (mod != 0) {
                div = mod * 10 / denominator;
                mod = mod * 10 % denominator;

                modString.append(div);
                if (firstMod.get(mod) != null) {
                    // 出现循环
                    modString.insert(firstMod.get(mod).intValue(), '(');
                    modString.insert(modString.length(), ')');
                    break;
                }
                bit++;
                firstMod.put(mod, bit);

            }
            sb.append(modString);
            return sb.toString();
        }
    }

}
