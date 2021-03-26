package old.Data20180424;

/**
 * 29. Divide Two Integers
 */
public class DivideTwoInteger {
    public static void main(String[] args){
        System.out.print(new DivideTwoInteger().divide(2, 1));
    }
    public int divide(int dividend, int divisor){
        int res = 0;
        if(divisor == 0)
            return 0;
        int div = (divisor < 0) ? -divisor : divisor;
        int sum = divisor;
        while(sum <= dividend){
            sum += divisor;
            res++;
        }
        return res;
    }
}
