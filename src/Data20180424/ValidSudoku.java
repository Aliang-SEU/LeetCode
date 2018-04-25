package Data20180424;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board){
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        Set<Character> cube = new HashSet<>();
        for(int i = 0; i < 9; i++){
            row.clear();
            col.clear();
            cube.clear();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' && !col.add(board[j][i]))
                    return false;

                int h = 3 * (i / 3);
                int c = 3 * (i % 3);
                if(board[h + j / 3][c + j % 3] != '.' && !cube.add(board[h + j / 3][c + j % 3]))
                    return false;
            }
        }
        return true;
    }
}
