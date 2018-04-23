package Data20180422;

import java.util.ArrayList;

/**
 * 119. Pascal triangle
 */
public class PascalTriangleII {
    public static void main(String[] args){
        System.out.print(new PascalTriangleII().getRow(4));
    }
    public ArrayList<Integer> getRow(int rowIndex){
        int[] res = new int[rowIndex + 1];
        for(int i = 0; i < rowIndex + 1; i++){
            res[0] = 1;
            for (int j = i; j > 0; j--) {
                res[j] = res[j] + res[j - 1];
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < res.length; i++){
            result.add(res[i]);
        }
        return result;
    }
}
