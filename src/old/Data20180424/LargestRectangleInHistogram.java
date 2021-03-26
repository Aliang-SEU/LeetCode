package old.Data20180424;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args){
        int[] a = new int[]{2,1,2};
        System.out.print(new LargestRectangleInHistogram().largestRectangleArea(a));

    }
    /**
     * 解决方法的主要思想为构建一个升序栈
     * @param height
     * @return
     */
    public int largestRectangleArea(int[] height) {
        int n = height.length, result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && (height[stack.peek()] > height[i])){
                int h = height[stack.peek()];
                stack.pop();
                result = Math.max(result, h * (i - 1 - (stack.isEmpty() ? -1 : stack.peek())));
            }
            stack.push(i);
        }
        while(!stack.empty()){
            int h = height[stack.peek()];
            stack.pop();
            result = Math.max(result, h * (n - 1 - (stack.isEmpty() ? -1 : stack.peek())));
        }
        return result;
    }
}
