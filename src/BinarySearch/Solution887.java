package BinarySearch;

import java.util.Arrays;

/**
 * 887. 鸡蛋掉落
 * @Author Hao Chen
 * @Create 2022/7/25 22:56
 */
public class Solution887 {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i < n+1; ++i){
            Arrays.fill(dp[i],i);
        }
        for(int i = 0; i <= k; ++i){
            dp[0][i] = 0;
        }
        dp[1][0] = 0;
        for(int i = 1; i <= n; ++i){
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for(int i = 2; i <= n; ++i){
            for(int j = 2; j <= k; ++j){
                int left = 0, right = i;
                while(left < right){
                    int mid = left + ((right-left)>>1);
                    int breakCount = dp[mid-1][j-1];
                    int notBreakCount = dp[i-mid][j];
                    if(breakCount < notBreakCount){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                dp[i][j] = Math.max(dp[left-1][j-1],dp[i-left][j])+1;
            }
        }
        return dp[n][k];
    }
}
