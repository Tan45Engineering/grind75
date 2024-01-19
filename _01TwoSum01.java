import java.util.Arrays;

/*Problem Statement: Grind 75 Series: 01/75
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
* */
public class _01TwoSum01 {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];

        //Iterate through the array using two nested loops
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                //check if the sum of elements at indices i and j equals the target
                if(nums[i] + nums[j] == target){
                    //if the sum matches the target, store the indices
                    sol[0] = i; //index of first element
                    sol[1] = j; //index of second element
                    return sol;
                }
            }
        }
        //If no solution is available, return empty array
        return sol;
    }
    public static void main(String args[]){
        System.out.println("Tan45Engineering");
        _01TwoSum01 object = new _01TwoSum01();
        int nums[] = {2,7,11,15};
        int target = 9;
        int resultArr[] = object.twoSum(nums, target);
        String stringArr = Arrays.toString(resultArr);
        System.out.println(stringArr);
    }
}
