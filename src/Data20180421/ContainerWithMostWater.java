package Data20180421;

/**
 *  11. Container With Most Water
 */
public class ContainerWithMostWater {

    public static void main(String[] args){

        System.out.print(new ContainerWithMostWater().maxArea(new int[]{14,0,12,3,8,3,13,5,14,8}));
    }

    public int maxArea(int[] height){
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while(left < right){
            maxArea = Math.max(maxArea, (right - left) * ((height[left] > height[right]) ? height[right] : height[left]));

            if(height[left] > height[right])
                right--;

            else if(height[left] <= height[right])
                left++;
        }
        return maxArea;
    }
}
