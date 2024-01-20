import java.util.Arrays;

/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
*/
public class _36CoinChange {
    public int coinChange(int[] coins, int amount) {
        //create an array to store the minimum number fo coins needed for each amount
        int[] dp = new int[amount + 1];

        //initialize the array with a value gratr than the maximum possible number of coins
        Arrays.fill(dp, amount + 1);

        //the minimum number of coins needed to make 0 is 0
        dp[0] = 0;

        //iterate through each coin denomination
        for(int coin: coins){
            //update dp array for each amount from coin to the target amount
            for(int i = coin; i <= amount; i++){
                //dp[i - coin] + 1 represents the number of coins needed for the remaining amount after using a coin
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        //if dp[amount] is still greater than amount, it means no combination of coins is possible
        return dp[amount] > amount ? -1: dp[amount];
    }

    public static void main(String args[]){
        _36CoinChange obj = new _36CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(obj.coinChange(coins, amount));
    }
}
//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
//[0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]

//available coins: 1, 2, 5
