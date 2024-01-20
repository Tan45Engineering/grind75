import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.*/
public class _30_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        //sort the array to easily handle duplicates and to use two-pointer approach
        Arrays.sort(nums);

        int n = nums.length;

        //iterate throught the array, fixing one element (nums[i]) at a time
        for(int i = 0; i < n-2; i++){
            //skip the duplicates to avoid duplicte triplets
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            //use two pointers, left and right, to find the other two elements
            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    //found a triplet, add it to the result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //skip duplicates for the left pointer
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }

                    //skip duplicates for the right pointer
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }

                    //move the pointers to the next unique elements
                    left++;
                    right--;

                }else if(sum < 0){
                    //if sum is less than 0, move the left pointer to increase the sum
                    left++;
                }else{
                    //if sum is greater than 0, move the right pointer to decrease the sum
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String args[]){
        _30_3Sum obj = new _30_3Sum();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(obj.threeSum(nums));
    }
}

// -1,0,1,2,-1,-4
// -1, -1, -1, -1, 0, 1, 2, 2
