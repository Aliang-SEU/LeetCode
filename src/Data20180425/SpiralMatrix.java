package Data20180425;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        new SpiralMatrix().spiralOrder(matrix);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0)
            return res;

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while(true){
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if(left > right || top > bottom) break;

            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if(left > right || top > bottom) break;

            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if(left > right || top > bottom) break;

            for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if(left > right || top > bottom) break;
        }
        return res;
    }
}
