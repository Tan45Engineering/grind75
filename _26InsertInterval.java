import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]*/
public class _26InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //create a list to store the result
        List<int[]> result = new ArrayList<>();

        //add intervals to the result list where endTime is less than newIterval's startTime
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        //merge overlapping intervals with newInterval
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        //add the merged interval to the result list
        result.add(newInterval);

        //add the remaining intervals to the result list
        while(i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        //convert the lis to a 2d array and return
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String args[]){
        _26InsertInterval obj = new _26InsertInterval();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = obj.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result));
    }
}

//[[1,3],[6,9],[12,15]], newInterval = [7,10]
//result = [[1,3],[6,10],[12,15]]

//[[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//result = [[1,2],[3,10],[12,16]]
