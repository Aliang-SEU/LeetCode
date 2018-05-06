package Data20180506;

import java.util.Arrays;

public class SetMatrixZero {

    public static void main(String[] args){
        int[][] a = new int[][]{{1,1,1},{0,0,2},{1,1,1}};

        for(int[] b : a)
            System.out.println(Arrays.toString(b));

        System.out.println();

        new SetMatrixZero().setZeroes(a);

        for(int[] b : a)
            System.out.println(Arrays.toString(b));

    }

    public void setZeroes(int[][] matrix){
        int col0 = 1;

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0)
                col0 = 0;
            for(int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                }
            }
        }

        for(int i = matrix.length - 1;i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col0 == 0) matrix[i][0] = 0;
        }
    }

}
