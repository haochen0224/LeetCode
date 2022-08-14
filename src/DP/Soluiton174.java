package DP;

/**
 * 174. 地下城游戏
 * @Author Hao Chen
 * @Create 2022/8/13 22:55
 */
public class Soluiton174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];
        dp[n-1][m-1] = dungeon[n-1][m-1] >= 0 ? 1 : -dungeon[n-1][m-1]+1;
        for(int i = n; i >= 0; --i){
            dp[i][m] = Integer.MAX_VALUE;
        }
        for(int j = m; j >= 0; --j){
            dp[n][j] = Integer.MAX_VALUE;
        }
        for(int i = n-1; i >= 0; --i){
            for(int j = m-1; j >= 0; --j){
                if(i == n-1 && j == m-1){
                    continue;
                }
                int res = Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = res <= 0 ? 1 : res;
            }
        }
        return dp[0][0];
    }
}
