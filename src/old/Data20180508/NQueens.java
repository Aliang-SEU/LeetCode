package old.Data20180508;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args){
        System.out.println(new NQueens().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        }
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }

    public void dfs(char[][] board, int level, List<List<String>> res){
        if(level == board.length){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < board.length; i++)
                list.add(new String(board[i]));
            res.add(list);
        }else {
            for (int i = 0; i < board[level].length; i++) {
                if(posEffective(board, level, i)){
                    board[level][i] = 'Q';
                    dfs(board, level + 1, res);
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
