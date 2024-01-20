/*Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.



Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].*/
public class _51PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        //caluclate the total sum
        for(int num: nums){
            totalSum += num;
        }

        //if totalSum is odd, partition is not possible
        if(totalSum %2 != 0){
            return false;
        }

        //calculte target sum, that is half of total sum
        int targetSum = totalSum/2;//11

        //create a boolean array to memoize subproblem results
        boolean[] dp = new boolean[targetSum + 1];

        //intialization: it's always possible to achieve a sum of 0
        dp[0] = true;

        //iterate over the array elements
        for(int num: nums){
            //iterate backward from the target sum to the current element
            for(int i = targetSum; i>= num; i--){
                //check if it's possible to achieve the current sum using current element
                dp[i] = dp[i] || dp[i - num];
            }
        }

        //the final result is stored in dp[targetSum]
        return dp[targetSum];
    }

    public static void main(String args[]){
        _51PartitionEqualSubsetSum obj = new _51PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        System.out.println(obj.canPartition(nums));
    }
}

// 1, 5, 11, 5
//total sum = 22
//target sum = 11
// [1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1]
