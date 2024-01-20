import java.util.Arrays;
import java.util.Comparator;

/*We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.



Example 1:



Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job.
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.*/
public class _73MaximumProfitinJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        //create an array of jobs to store startTime, endTime and profit
        int[][] jobs = new int[n][3];
        for(int i = 0; i < n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        //sort the jobs based on endTime
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        //dp array to store the maximum profit at each index
        int[] dp = new int[n];
        dp[0] = jobs[0][2]; //initialize with profit of the first job
        //dp = {50, 50, 90, 120}

        //iterate through provided jobs
        for(int i = 1; i < n; i++){
            int currentProfit = jobs[i][2]; //70
            int prevCompatibleJobIndex = binarySearch(jobs, i); //0

            //maximum profit for the current Index
            dp[i] = Math.max(dp[i-1], currentProfit + (prevCompatibleJobIndex == -1 ? 0: dp[prevCompatibleJobIndex]));
        }

        return dp[n-1];//return result
    }

    //binary search to find the latest job that doesn't overlap with the current job
    private int binarySearch(int[][] jobs, int currentIndex){
        int low = 0;
        int high = currentIndex - 1;

        while(low <= high){
            int mid = (low + high)/2;
            if(jobs[mid][1] <= jobs[currentIndex][0]){
                if(jobs[mid+1][1] <= jobs[currentIndex][0]){
                    low = mid+1;
                }else{
                    return mid;
                }
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]){
        _73MaximumProfitinJobScheduling obj = new _73MaximumProfitinJobScheduling();
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        System.out.println(obj.jobScheduling(startTime, endTime, profit));
    }
}
