package Data20180506;

public class Searcha2DMatrix {

    public static void main(String[] args){
        int[][] a = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(new Searcha2DMatrix().searchMatrix(a, 3));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;

        int low = 0, high = matrix.length - 1;
        int end = matrix[0].length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(matrix[mid][end] > target)
                high = mid;
            else if(matrix[mid][end] < target)
                low = mid + 1;
            else if(matrix[mid][end] == target)
                return true;
        }
        int i = low;
        low = 0;
        high = matrix[0].length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[i][mid] > target)
                high = high - 1;
            else if(matrix[i][mid] == target)
                return true;
            else
                low = mid + 1;
        }
        return false;
    }

}
