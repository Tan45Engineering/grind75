/*You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.*/
public class _59ContainerWithMostWater {
    public int maxArea(int[] height) {
        //Initialize pointers at the beginning and end of the array
        int left = 0;
        int right = height.length - 1;

        //Initalize variable to store the maximum area
        int maxArea = 0;

        //continue until the left pointer meets the right pointer
        while(left < right){
            //calculate the width between two pointers
            int width = right - left;

            //calculate the height for the container, which is the min height of the two lines
            int containerHeight = Math.min(height[left], height[right]);

            //calculate area and update maxArea
            int currentArea = width*containerHeight;
            maxArea = Math.max(maxArea, currentArea);

            //move the pointers based on the condition to maximize the area
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String args[]){
        _59ContainerWithMostWater obj = new _59ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(height));
    }
}
