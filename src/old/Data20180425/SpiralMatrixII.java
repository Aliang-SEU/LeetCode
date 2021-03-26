package old.Data20180425;

import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args){
        int[][] res = new SpiralMatrixII().generateMatrix(3);
        for (int[] a : res)
        System.out.println(Arrays.toString(a));
    }

    public int[][] generateMatrix(int n){
        int[][] res = new int[n][n];
        int num = 1;
        int end = n * n;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while(true){
            for(int i = left; i <= right; i++)
                res[top][i] = num++;
            top++;
            if(num > end) break;

            for(int i = top; i <= bottom; i++)
                res[i][right] = num++;
            right--;
            if(num > end) break;

            for(int i = right; i >= left; i--)
                res[bottom][i] = num++;
            bottom--;
            if(num > end) break;

            for(int i = bottom; i >= top; i--)
                res[i][left] = num++;
            left++;
            if(num > end) break;
        }
        return res;
    }
}
