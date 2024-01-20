/*Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3*/
public class _19MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                //if the count becomes 0, chosse the current element as the candidate
                candidate = nums[i];
                count = 1;
            }else if(candidate == nums[i]){
                //if the current element is the same as the candidate, increment the count
                count++;
            }else{
                //if the current element is different, decrement the count
                count--;
            }
        }

        return candidate;

    }

    public static void main(String args[]){
        _19MajorityElement obj = new _19MajorityElement();
        int[] nums = {3, 2, 3};
        System.out.println(obj.majorityElement(nums));
    }
}

// candidate: 2, 1, 2
// count: 0
