import java.util.Arrays;
import java.util.HashMap;

/*Problem Statement: Grind 75 Series: 01/75
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
* */
public class TwoSum01_02 {
    public int[] twoSum(int[] nums, int target) {
        //Create a hashmap to store the values and their corresponding indices
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();

        //Iterate through the array
        for(int i = 0;  i < nums.length; i++){
            int complement = target - nums[i];

            //check if the complement value is already present in the hashmap
            if(valueToIndex.containsKey(complement)){
                //if found, return the indices of the current element and the complement's value
                return new int[]{valueToIndex.get(complement), i};
            }
            //if the complement is not found, add the element and its index in the hashmap
            valueToIndex.put(nums[i], i);
        }

        //if no solution found, return empty array
        return new int[0];
    }
    public static void main(String args[]){
        System.out.println("Tan45Engineering");
        TwoSum01 object = new TwoSum01();
        int nums[] = {2,7,11,15};
        int target = 9;
        int resultArr[] = object.twoSum(nums, target);
        String stringArr = Arrays.toString(resultArr);
        System.out.println(stringArr);
    }
}
