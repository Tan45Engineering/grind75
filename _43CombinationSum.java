import java.util.ArrayList;
import java.util.List;

/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.*/
public class _43CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        //start the backtracking process
        backtrack(candidates, target, 0, currentCombination, result);

        return result;
    }

    private void backtrack(int[] candidates, int remainingTarget, int start, List<Integer> currentCombination, List<List<Integer>> result){

        //base case: if the ramaining target is 0, add the current combination to the result list
        if(remainingTarget == 0){
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        //iterate through candidate starting from start index
        for(int i = start; i < candidates.length; i++){
            //skip duplixates to avoid duplicate combinations
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }

            //skip candidates that are greater than the reamining target
            if(candidates[i] > remainingTarget){
                continue;
            }

            //include the current candidate in the combination
            currentCombination.add(candidates[i]);

            //recursively backtrack with the updated remaining target and the same start index
            backtrack(candidates, remainingTarget - candidates[i], i, currentCombination, result);

            //remove the last added candidate to backtrack
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String args[]){
        _43CombinationSum obj = new _43CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(obj.combinationSum(candidates, target));
    }
}

// [2, 3, 6, 7]: target: 7, 5, 3, 0
//[2, 2, 3]
