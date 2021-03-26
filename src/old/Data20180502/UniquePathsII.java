package old.Data20180502;

public class UniquePathsII {
    public static void main(String[] args){
        int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(a));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0] == 0)
            dp[0][0] = 1;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(obstacleGrid[i][j] == 1 || (i == 0 && j == 0))
                    continue;
                else if(i == 0)
                    dp[0][j] = dp[0][j - 1];
                else if(j == 0)
                    dp[i][0] = dp[i - 1][0];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
