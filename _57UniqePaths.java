/*There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.



Example 1:


Input: m = 3, n = 7
Output: 28*/
public class _57UniqePaths {
    public int uniquePaths(int m, int n) {
        //create a 2D array to store the number of unique paths for each cell, dp
        int[][] dp = new int[m][n];

        //initialize the top row and left column to 1 since there's only one way to reach any cell in the top row or left coluumn
        for(int i = 0; i  < m; i++){
            dp[i][0] = 1;
        }

        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }

        //fill the rest of the array based on the number of paths frmo top and left cells
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        //the bottom-right cells now contains the total number of unique paths
        return dp[m-1][n-1];
    }

    public static void main(String args[]){
        _57UniqePaths obj = new _57UniqePaths();
        int m = 3;
        int n = 7;
        System.out.println(obj.uniquePaths(m, n));
    }
}

// dp[i][j] = dp[i-1][j] + dp[i][j-1];
