package old.DefaultPackage;
import java.util.List;
import java.util.ArrayList;
public class Code11 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int j = binarySearch(array, sum);    // upper bound
        int mid = j / 2;
        int left = mid-1, right = mid, result_left = -1, result_right = -1;
        int multi_result = Integer.MAX_VALUE;
        while(left>=0 && right <= j){
            if(array[left] + array[right] == sum){
                if(array[left]*array[right] < multi_result){
                    multi_result = array[left]*array[right];
                    result_left = left;
                    result_right = right;
                    left--;
                    right++;
                }else{
                    left--;
                    right++;
                }
            }else if(array[left] + array[right] > sum){
                left--;
            }else
                right++;
        }
        if(result_left != -1 && result_right != -1){
            list.add(array[result_left]);
            list.add(array[result_right]);
        }
        return list;	
    }
    public int binarySearch(int[] a, int num){
        if(a.length == 0)
            return -1;
        int low = 0, high = a.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(a[mid] > num){
                high = mid - 1;
            }else if(a[mid] < num){
                low = mid + 1;
            }else{
                break;
            }
        }
        return low;
    }
    public static void main(String[] args) {
    	Code11 c= new Code11();
    	List<Integer> list = c.FindNumbersWithSum(new int[]{1,2,3,4,5,6,7},6);
    	for(Integer a : list ) {
    		System.out.println(a);
    	}
    }
}