import java.util.Arrays;

/*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]*/
public class _49SortColors {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        //traverse the array
        while(mid <= high){
            if(nums[mid] == 0){
                //swap nums[low] and nums[mid], move both the pointers
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                //leave nums[mid] in its place and move mid pointer
                mid++;
            }else if(nums[mid] == 2){
                //swap nums[mid] and nums[high], move high pointer
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]){
        _49SortColors obj = new _49SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

//[2,0,2,1,1,0], [0, 0, 2, 1, 1, 2], [0, 0, 1, 1, 2, 2]
//low= 0, 1, 2
//mid = 0, 1, 2, 3, 4
//high = 5, 4, 3

//three pointers
//traverse the array
//low, high, mid
