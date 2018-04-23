package Data20180422;

import java.util.ArrayList;

/**
 *  Pascal Triangle
 */
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(numRows == 0)
            return res;
        int[] temp = new int[numRows];
        temp[0] = 1;
        for(int i = 0; i < numRows; i++){
            for(int j = i; j > 0; j--){
                temp[j] = temp[j] + temp[j - 1];
            }

            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                list.add(temp[j]);
            }
            res.add(list);
        }
        return res;
    }


}
