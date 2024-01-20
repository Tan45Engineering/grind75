import java.util.Arrays;

/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]*/
public class _37ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        //initialize arrays to store products to the left and right of each element
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        //initialize the result array
        int[] result = new int[n];

        //calculate products to the left of each element
        int leftProduct = 1;
        for(int i = 0; i < n; i++){
            leftProducts[i] = leftProduct;
            leftProduct *= nums[i];
        }

        //calculate products to the right of each element
        int rightProduct = 1;
        for(int i = n-1; i>= 0; i--){
            rightProducts[i] = rightProduct;
            rightProduct *= nums[i];
        }

        //calculate final result
        for(int i = 0; i < n; i++){
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }

    public static void main(String args[]){
        _37ProductofArrayExceptSelf obj = new _37ProductofArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = obj.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}

//[1, 2, 3, 4]
//leftProduct = [1, 1, 2, 6]
//rightProduct = [24, 12, 4, 1]
//resultArray = [24, 12, 8, 6]
