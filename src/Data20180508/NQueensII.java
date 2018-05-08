package Data20180508;

public class NQueensII {

    private int count = 0;
    public int solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        }
        dfs(board, 0);
        return count;
    }

    public void dfs(char[][] board, int level){
        if(level == board.length){
            count++;
        }else {
            for (int i = 0; i < board[level].length; i++) {
                if(posEffective(board, level, i)){
                    board[level][i] = 'Q';
                    dfs(board, level + 1);
                    board[level][i] = '.';
                }
            }
        }
    }

    private boolean posEffective(char[][] board, int row, int col){
        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < row; j++) {
                if (board[j][i] == 'Q' && (i == col || i + row == j + col || row + col == i + j))
                    return false;
            }
        }
        return true;
    }

}
