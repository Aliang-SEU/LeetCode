package old.Data20180425;

import java.util.ArrayList;

public class PermutationSequence {
    public static void main(String[] args){
        System.out.println(new PermutationSequence().getPermutation(3, 3));
    }
    public String getPermutation(int n, int k){
        int[] factorial = new int[n + 1];
        int sum = 1;
        factorial[0] = 1;
        for(int i = 1; i < factorial.length; i++){
            sum *= i;
            factorial[i] = sum;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> number = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            number.add(i);

        k--;
        for(int i = 1; i <= n; i++){
            int index = k / factorial[n - i];
            sb.append(number.get(index));
            number.remove(index);
            k %= factorial[n - i];
        }
        return sb.toString();
    }
}
