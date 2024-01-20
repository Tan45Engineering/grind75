import java.util.ArrayList;
import java.util.List;

/*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]*/
public class _44Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        //start the backtracking process
        backtrack(nums, used, currentPermutation, result);

        return result;

    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result){
        //base case: if the current permutation size equals the array length, add this to the result
        if(currentPermutation.size() == nums.length){
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        //iterate through the array elements
        for(int i = 0; i < nums.length; i++){
            //skip elements that have been used
            if(used[i]){
                continue;
            }

            //include the current element in the permutation
            currentPermutation.add(nums[i]);
            used[i] = true;

            //recursively backtrack with the updates state
            backtrack(nums, used, currentPermutation, result);

            //remove the last added element to backtrack
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String args[]){
        _44Permutations obj = new _44Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(obj.permute(nums));
    }
}

// 1 2 3
// 1 2 3, 1 3 2, 2 1

//currentPermuatation
//result
//used
