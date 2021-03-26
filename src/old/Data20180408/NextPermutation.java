package old.Data20180408;

import java.util.Arrays;

public class NextPermutation {
	public static void main(String[] args) {
		int[] a = {3,2,1};
		nextPermutation(a);
		System.out.println(Arrays.toString(a));
	}
    public static void nextPermutation(int[] num) {
    	boolean flag = false;
        for(int i = 0; i < num.length - 1; i++) {
        	if(num[i] > num[i+1])
        		continue;
        	else {
        		flag = true;
        		break;
        	}
        }
        if(flag == false) {
            reverse(num, 0, num.length);
        }else {
        	int idx = num.length - 1;
        	int i = num.length - 1;
        	while(--idx >= 0) {
        		i = num.length - 1;
	        	while(i > idx) {
	        		if(num[idx] < num[i])
	        			break;
	        		else {
	        			i--;
	        		}
	        	}
	        	if(i == idx) {
	        		continue;	//没找到，下一个
	        	}
	        	//交换idx 和 i
	        	else{
	        		int temp = num[i];
		        	num[i] = num[idx];
		        	num[idx] = temp;
		        	break;
	        	}
        	}
            reverse(num, ++idx, num.length);
        }	
    }
    private static void reverse(int[] a, int start, int end){
        int len = end - start;
        for(int i = start; i < len / 2 + start; i++) {
            int temp = a[i];
            a[i] = a[end - i + start - 1];
            a[end - i + start - 1] = temp;
        }
    }
}
