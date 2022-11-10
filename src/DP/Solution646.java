package DP;

import java.util.Arrays;

/**
 * 646. 最长数对链
 * @Author Hao Chen
 * @Create 2022/11/10 17:29
 */
public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0 || pairs[0].length == 0){
            return 0;
        }
        int n = pairs.length;
        Arrays.sort(pairs,(a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int[] dp = new int[n];
        int res = 1;
        for(int i = 0; i < n; ++i){
            dp[i] = 1;
            for(int j = 0; j < i; ++j){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
