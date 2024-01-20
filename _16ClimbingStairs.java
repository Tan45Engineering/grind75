/*You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps*/
public class _16ClimbingStairs {
    public int climbStairs(int n) {
        //if n is less than 3, there are n ways to climb the stairs
        if(n < 3){
            return n;
        }

        //create an array to store the number of distinct ways for each step up to n
        int[] dp = new int[n+1];

        //initialize base cases for n = 0, 1, 2
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        //fill the dp array for steps starting from 3 to n
        for(int i = 3; i <= n; i++){
            //the number of ways to reach i-th step is the sum of ways to reach the previous two steps
            dp[i] = dp[i-1] + dp[i-2];
        }

        //the result is stored in dp[n], which contains the number of distinct ways to reach the top
        return dp[n];
    }

    public static void main(String args[]){
        _16ClimbingStairs obj = new _16ClimbingStairs();
        int n = 2;
        System.out.println(obj.climbStairs(n));
    }
}
