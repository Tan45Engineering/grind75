import java.util.ArrayList;
import java.util.List;

/*Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
*/
public class _54Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        //Start the backtracking process
        backtrack(nums, 0, currentSubset, result);

        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> result){
        //add the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        //Explores all possible subsets by iterating through the array
        for(int i = start; i < nums.length; i++){
            //choose next element in the current subset
            currentSubset.add(nums[i]);

            //explore other possible subsets
            backtrack(nums, i+1, currentSubset, result);

            //unchoose (backtrack) the last element
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String args[]){
        _54Subsets obj = new _54Subsets();
        int[] nums = {0};
        System.out.println(obj.subsets(nums));
    }
}
