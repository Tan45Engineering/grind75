/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.*/
public class _69TrappingRainWater {
    public int trap(int[] height) {
        //base case: no trapping water if height is null or less than 3
        if(height == null || height.length <= 2){
            return 0;
        }

        //left and right pointers
        int left = 0;
        int right = height.length - 1;

        //left and right pointers for max heights
        int leftMax = 0;
        int rightMax = 0;

        int waterTrapped = 0; // 0, 1, 2, 3, 5, 6

        while(left < right){
            //update the max heights from left and right
            leftMax = Math.max(leftMax, height[left]); // 0, 1, 2
            rightMax = Math.max(rightMax, height[right]); // 1, 2, 3

            //calculate the amount of water that can be trapped at the current position
            if(leftMax < rightMax){
                waterTrapped += leftMax - height[left];
                left++;
            }else{
                waterTrapped += rightMax - height[right];
                right--;
            }
        }

        return waterTrapped;
    }

    public static void main(String args[]){
        _69TrappingRainWater obj = new _69TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(height));
    }
}
