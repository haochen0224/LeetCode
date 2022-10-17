package DP;

import java.util.Arrays;

/**
 * 1278. 分割回文串 III
 * @Author Hao Chen
 * @Create 2022/10/16 21:29
 */
public class Solution1278 {
    public int palindromePartition(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i <= n; ++i){
            Arrays.fill(dp[i],n);
        }
        for(int i = 1; i <= n; ++i){
            int len = Math.min(i,k);
            for(int j = 1; j <= len; ++j){
                if(j == 1){
                    dp[i][j] = change(s,j-1,i-1);
                }else{
                    for(int m = j-1; m < i; ++m){
                        dp[i][j] = Math.min(dp[i][j],dp[m][j-1]+change(s,m,i-1));
                    }
                }
            }
        }
        return dp[n][k];
    }
    private int change(String s,int left,int right){
        int res  = 0;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                ++res;
            }
        }
        return res;
    }
}
