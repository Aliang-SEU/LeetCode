package old.Data20180507;

import java.util.Stack;

public class MaxArea {

    public static void main(String[] args){
        int[] a = new int[]{1,1,2,3,4,5,4,3,2,1};
        MaxArea sample = new MaxArea();
        System.out.println(sample.maxRecArea(a) + " " + sample.maxRectangleArea(a));
    }


    public int maxRecArea(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int area = arr[j] * (i - k - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int area = arr[j] * (arr.length - k - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int maxRectangleArea(int[] arr){

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            if(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int id = stack.pop();
                int area = arr[id];
                maxArea = Math.max(maxArea, area);
                while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                    int idx = stack.pop();
                    int k = stack.isEmpty() ? -1 : stack.peek();
                    area = arr[idx] * (id - k);
                    maxArea = Math.max(maxArea, area);
                }
            }
            stack.push(i);
        }
        if(!stack.isEmpty()){
            int id = stack.pop();
            int area = arr[id];
            maxArea = Math.max(maxArea, area);
            while(!stack.isEmpty()){
                int idx = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                area = arr[idx] * (id - k);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
