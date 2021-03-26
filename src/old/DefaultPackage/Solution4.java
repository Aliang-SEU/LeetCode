package old.DefaultPackage;
public class Solution4 {
	public static void main(String[] args) {
		int[] A = new int[20];
		for(int i=0; i<10; i++)
			A[i] = i;
		int[] B = new int[20];
		for(int i=0; i<10; i++)
			B[i] = i+1;
		merge(A,10,B,10);
		for(int i=0; i<20; i++)
			System.out.println(A[i]);
	}
    public static void merge(int A[], int m, int B[], int n) {
        	int[] C = new int[A.length];
        	int k = 0, i = 0, j = 0;
        	while(true) {
        		if(i == m || j == n ) break;
                if(B[j] < A[i]){
                    C[k++] = B[j++];
                }
                else{
                    C[k++] = A[i++];
                } 
                
    		}
        	if(i == m){
                for(  ; j < n; )
                   C[k++] = B[j++];
            }
        	else if(j == n){
                 for(  ; i < m; )
                   C[k++] = A[i++];
            }
        	for(i = 0; i<A.length; ++i)
        		A[i] = C[i];
    }
}