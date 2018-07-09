package Data20180709;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

    private int MIN_VALUE = Integer.MAX_VALUE;

    private Stack<Integer> stack = new Stack<>();
    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if(x <= MIN_VALUE){
            stack.push(MIN_VALUE);
            MIN_VALUE = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == MIN_VALUE) {
            MIN_VALUE = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return MIN_VALUE;
    }

}
