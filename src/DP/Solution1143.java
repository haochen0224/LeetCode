package DP;

/**
 * 1143. 最长公共子序列
 * @Author Hao Chen
 * @Create 2022/8/12 19:55
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 == 0 || len2 == 0){
            return 0;
        }
        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 0;
        int maxLen = 0;
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }
        return maxLen;
    }
}
