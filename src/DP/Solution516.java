package DP;

/**
 * 516. 最长回文子序列
 * @Author Hao Chen
 * @Create 2022/9/15 17:40
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n-1; i >= 0; --i){ //这里要逆序遍历，因为之后的dp[i+1][j]和dp[i][j-1]必须要是访问过的位置
            dp[i][i] = 1;
            for(int j = i+1; j < n; ++j){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
