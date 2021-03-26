package old.Data20180425;

public class RotateImage {
    public static void main(String[] args){
        int[][] a = new int[][]{{1,2,3,4},
                                {5,6,7,8},
                                {4,5,6,7},
                                {2,3,4,5}};
        RotateImage r = new RotateImage();

        r.print(a);
        r.rotate3(a);
        r.print(a);

    }

    /**
     * 开辟一个额外的矩阵来存储
     * 对应的映射关系为a[i][j] = a[j][n - 1 - i]
     * @param matrix
     */
    public void rotate1(int[][] matrix){
        int[][] temp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                temp[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }
    public void print(int[][] a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * 由外圈到内圈依次赋值
     * @param matrix
     */
    public void rotate2(int[][] matrix){
        int temp = 0;
        for(int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }

    public void rotate3(int[][] matrix){
        //对角反转
        for(int i = 0; i < matrix.length; i++){
            int len = matrix.length -1 - i;
            for(int j = 0; j < len; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1 - i];
                matrix[matrix.length - 1 - j][matrix.length - 1 - i] = temp;
            }
        }
        //水平翻转
        int len = matrix.length / 2;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
    }
}
