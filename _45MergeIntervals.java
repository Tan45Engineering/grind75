import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].*/
public class _45MergeIntervals {
    public int[][] merge(int[][] intervals) {
        //check if the array is empty or has only one interval
        if(intervals == null || intervals.length <= 1){
            return intervals;
        }

        //sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        //iterate through sorted intervals to merge overlapping intervals
        for(int i = 1; i < intervals.length; i++){
            int[] nextInterval = intervals[i];

            //check for overlap
            if(currentInterval[1] >= nextInterval[0]){
                //merge the overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            }else{
                //add non-overlapping interval to the result
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        //add the last interval to the result
        mergedIntervals.add(currentInterval);

        //convert list to array
        int[][] result = new int[mergedIntervals.size()][2];
        for(int i = 0; i < mergedIntervals.size(); i++){
            result[i] = mergedIntervals.get(i);
        }

        return result;
    }

    public static void main(String args[]){
        _45MergeIntervals obj = new _45MergeIntervals();
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] result = obj.merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }
}

//sort the array based on start times

//[15, 18]
