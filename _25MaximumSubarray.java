/*Given an integer array nums, find the
subarray
 with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.*/
public class _25MaximumSubarray {
    public int maxSubArray(int[] nums) {
        //check for empty array
        if(nums == null || nums.length == 0){
            return 0;
        }

        //initialize variables to keep track of maximum sum and current sum
        int maxSum = nums[0];
        int currentSum = nums[0];

        //iterate through the array
        for(int i = 1; i < nums.length; i++){
            //decide whether to extend the current subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);//1

            //update the maximum sum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);//1
        }

        return maxSum;
    }

    public static void main(String args[]){
        _25MaximumSubarray obj = new _25MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(obj.maxSubArray(nums));
    }
}
