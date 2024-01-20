/*Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.



Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.*/
public class _75LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0;

        //index for arrayStack
        int index = 0;

        //create an array stack and modified array
        int[] arrayStack = new int[n+1];
        int[] modifiedHeights = new int[n+2];

        //initialize first and last elements to be -1
        modifiedHeights[0] = -1;
        modifiedHeights[n+1] = -1;

        //copy the elements from the heights to modifiedHeights
        for(int i = 1; i <=n; i++){
            modifiedHeights[i] = heights[i-1];
        }

        //initialize the stack with first element
        arrayStack[0] = 0;

        //iterate through modifiedHeights
        for(int i = 1; i <= n+1; i++){//i = 1, 2, 3, 4, 5
            int currHeight = modifiedHeights[i];

            //process elements from the stack until currHeight is greater
            while(modifiedHeights[arrayStack[index]] > currHeight){
                //pop the top element from the stack
                int currTop = arrayStack[index--];

                //calculat max area and update if it is greater than previous max
                result = Math.max(result, (i - arrayStack[index] - 1) * modifiedHeights[currTop]);
            }

            //pusth the current index onto the arrayStack
            arrayStack[++index] = i;
        }

        return result;
    }

    public static void main(String args[]){
        _75LargestRectangleinHistogram obj = new _75LargestRectangleinHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(obj.largestRectangleArea(heights));
    }
}

//modifiedHeights = [-1, 2, 1, 5, 6, 2, 3, -1]
//arrayStack = [0, 2, 3, 4, 0, 0, 0]
//index = 1, 0, 1, 2, 3, 2, 1
//currHeight = 1, 5, 6, 2
//currTop = 1, 3, 3
//result = 0, 2, 5, 10
// (5 -2 - 1)* 5 = 2*5 = 10
