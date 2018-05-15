package Data20180515;

import java.util.ArrayList;
import java.util.List;

/**
 * GeaceCode
 */
public class GrayCode {

    public static void main(String[] args){
        List<Integer> res = new GrayCode().grayCode1(11);
        for(Integer i : res){
            System.out.println(Integer.toBinaryString(i));
        }
    }

    public List<Integer> grayCode1(int n){
        List<Integer> res = new ArrayList<>();
        int maxNum = (int) Math.pow(2, n);

        for(int i = 0; i < maxNum; i++){
            int grayCode = (i >> 1) ^ i;
            res.add(grayCode);
        }
        return res;
    }
    public List<Integer> grayCode(int n){
        List<Integer> res = new ArrayList<>();
        if(n < 1)
            return res;
        res.add(0);
        int count = 0;
        int maxNum = (int)Math.pow(2, n);
        while(res.size() < maxNum){
            int size = res.size();
            for(int i = size - 1; i >= 0; i--){
                int temp = res.get(i);
                int add = 1 << count;
                res.add(temp + add);
            }
            count++;
        }
        return res;
    }
}
