package DP;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * @Author Hao Chen
 * @Create 2022/8/11 17:46
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; ++i){
            for(int coin : coins){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
