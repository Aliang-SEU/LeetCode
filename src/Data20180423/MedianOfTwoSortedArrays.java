package Data20180423;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There are two sorted arrays A and B of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args){
        System.out.print(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2,3,4,5}, new int[]{3,4,5,6,7}));
    }

    /**
     * 留个坑 日后填
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays1(int A[], int[] B){
        int len = A.length +  B.length;

        return 0.0;
    }

    public double findMedianSortedArrays(int A[], int[] B){
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(10, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        for(int i = 0; i < A.length; i++){
            max.offer(A[i]);
        }
        for(int i = 0; i < B.length; i++){
            max.offer(B[i]);
        }
        while(max.size() - min.size() != 1 && max.size() != min.size()){
            int value = max.poll();
            min.offer(value);
        }
        if(max.size() == min.size())
            return (max.peek() + min.peek()) / 2.0;
        else
            return max.peek();
    }

}
