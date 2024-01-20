import java.util.HashSet;

/*Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]
Output: true*/
public class _24ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //if the array has onlyl one element, it cannot have duplicates
        if(nums.length == 1){
            return false;
        }

        //create a hashSet to store the unique elements
        HashSet<Integer> set = new HashSet<>();

        for(int num: nums){
            //if the element is already in the hashset, return true
            // if(set.contains(num)){
            //     return true;
            // }else{
            //     //add the element to the hashset
            //     set.add(num);// 1 2 3
            // }

            if(!set.add(num)){
                return true;
            }
        }

        //if the loop completes without finding any duplicates, return false
        return false;
    }

    public static void main(String args[]){
        _24ContainsDuplicate obj = new _24ContainsDuplicate();
        int[] nums = {1, 2, 3, 1};
        System.out.println(obj.containsDuplicate(nums));
    }
}
