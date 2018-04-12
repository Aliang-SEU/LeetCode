
public class Solution2 {
	public static void main(String[] args) {
		int[] a = new int[] {3};
		int[] b = new int[] {1,2,4};
		double s = new Solution2().findMedianSortedArrays(a,b);
		System.out.println(s);
	}
	public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length > B.length)
            return findMedianSortedArrays(B,A);
        if(A == null || A.length == 0){
            if(B == null || B.length == 0)
            	return 0.0;
            else if(B.length % 2 == 1)
                return B[B.length / 2];
            else 
                return (B[B.length / 2] + B[B.length/2 - 1]) / 2.0; 
        }
        int m = A.length, n = B.length;
        int imin = 0, imax = m, mid = (m + n + 1) / 2;
        int i = 0, j = 0;
        while(imin <= imax){
            i = imin + (imax - imin) / 2;
            j = mid - i;
            if(i > 0 && A[i-1] > B[j])
                imax = i - 1;
            else if(i < m && B[j-1] > A[i])
                imin = i + 1;
            else break;
        }
        int left = 0;
        if(i == 0) left = B[j-1];
        else if (j == 0) left = A[i-1];
        else left = Math.max(A[i-1],B[j-1]);
        if((m + n) % 2==1)
            return left;
        int right = 0;
        if(i == m) right = B[j];
        else if (j == n) right = A[i];
        else right = Math.min(B[j],A[i]);
        return (left + right) / 2.0; 
    } 
}
