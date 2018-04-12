package DefaultPackage;
import java.util.ArrayList;
import java.util.Stack;
public class Code05 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
      Stack<Integer> stack = new Stack();
      int j = 0;
      for(int i = 0; i < pushA.length; i++){
          while(!stack.isEmpty() && stack.peek() == popA[j]){
              stack.pop();
              j++;
          }
          if(pushA[i] != popA[j]){
              stack.push(pushA[i]);
          }else { 
              j++;
              while(!stack.isEmpty() && stack.peek() == popA[j]){
            	  stack.pop();
            	  j++;
              }
          }
      }
      if(stack.isEmpty())
          return true;
      else
          return false;
    }
    
    public static void main(String[] args) {
    	int[] a = {1,2,3,4,5}, b = {4, 5, 3, 2, 1};
    	System.out.print(IsPopOrder(a,b));
    }
}