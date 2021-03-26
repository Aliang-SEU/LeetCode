package old.Data20180424;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.
 */
public class MaximalRectangle {
    public static void main(String[] args){


    }
    /**
     * 题意理解错误、、、
     * @param matrix
     * @return
     */
    public int maximalRectangle1(char[][] matrix) {
        int left = 0, top = 0, right = -1, bottom = -1;
        l1:for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    top = i;
                    break l1;
                }
            }
        }
        l2:for(int i = matrix.length - 1; i >= top; i--){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    bottom = i;
                    break l2;
                }
            }
        }
        l3:for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[j][i] == '1'){
                    left = i;
                    break l3;
                }
            }
        }
        l4:for(int i = matrix[0].length - 1; i>= left; i--){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[j][i] == '1'){
                    right = i;
                    break l4;
                }
            }
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}
