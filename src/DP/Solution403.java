package DP;

/**
 * 403. 青蛙过河
 * @Author Hao Chen
 * @Create 2022/10/2 18:31
 */
public class Solution403 {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for(int i = 1; i < n; ++i){
            if(stones[i] - stones[i-1] > i){
                return false;
            }
        }
        for(int i = 1; i < n; ++i){
            for(int j = i-1; j >= 0; --j){
                int k = stones[i] - stones[j];
                if(k > j+1){
                    break;
                }
                dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1]; //dp[i][k]表示上次跳跃距离为k时能否到达i位置
                if(i == n-1 && dp[i][k]){
                    return true;
                }
            }
        }
        return false;
    }
}
