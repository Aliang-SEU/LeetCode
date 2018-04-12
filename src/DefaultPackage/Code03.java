package DefaultPackage;
import java.util.Scanner;

public class Code03 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Code01 ob = new Code01();
		System.out.println(ob.lengthOfLongestSubstring(str));
	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	
    	int m = nums1.length;
    	int n = nums2.length;
    	
    	int imin = 0, imax=m, half_length = (m+n+1) >> 1;
    	int i,j;
    	double max_of_left,min_of_right;
    	
    	while(imin<=imax){
    		
    		i = (imin+imax) >> 1;
    		j = half_length - i;
    		
    		if(i<m && nums2[j-i]>nums1[i])
    			imin = i + 1;
    		else if(i>0 && nums1[i-1]>nums2[j])
    			imax = i - 1;
    		else{
    			if(i==0) max_of_left = nums2[j-1];
    			else if(j==0) max_of_left = nums1[i-1];
    			else{
    				max_of_left = Math.max(nums1[i-1], nums2[j-1]);
    			}
    			if((m + n) % 2 == 1)
    	                return max_of_left;

				 if (i == m) 
					 min_of_right = nums2[j];
				 else if(j == n) 
					 min_of_right = nums1[i];
				 else
				     min_of_right = Math.min(nums1[i], nums2[j]);

				 return (max_of_left + min_of_right) / 2.0;
    		}
    	}
    	 return 0.0;	
    }
}
