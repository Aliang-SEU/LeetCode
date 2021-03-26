package old.Data20180422;

import java.util.ArrayList;

/**
 * 120.triangle
 */
public class Triangle {

    /**
     * 空间复杂度o(n)
     * @param triangle
     * @return
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
        int n = triangle.size();
        int[] min = new int[n];

        for(int i = 0; i < n; i++){
            min[i] = triangle.get(n - 1).get(i);
        }

        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = n - 1; j >= n - i - 1; j--){
                min[j] = triangle.get(i).get(triangle.get(i).size() - (n - j)) + Math.min(min[j], min[j - 1]);
            }
        }
        return min[n - 1];
    }

    /**
     * 空间复杂度o(n2)
     * @param triangle
     * @return
     */
    public int minimumTotal1(ArrayList<ArrayList<Integer>> triangle){
        int n = triangle.size();
        int[][] min = new int[n][n];
        for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i++){
            min[n - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j < i + 1; j++){
                min[i][j] = triangle.get(i).get(j) + Math.min(min[i + 1][j], min[i + 1][j + 1]);
            }
        }
        return min[0][0];
    }

}
