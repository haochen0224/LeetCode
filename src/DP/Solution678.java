package DP;

/**
 * 678. 有效的括号字符串
 * @Author Hao Chen
 * @Create 2022/8/30 18:00
 */
public class Solution678 {
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; //dp[i][j] 表示下标[i,j]的字串是否有效
        for(int i = 0; i < n; ++i){
            if(s.charAt(i) == '*'){
                dp[i][i] = true;
            }
        }
        for(int i = 1; i < n; ++i){
            char ch1 = s.charAt(i-1), ch2 = s.charAt(i);
            dp[i-1][i] = (ch1 == '(' || ch1 == '*') && (ch2 == ')' || ch2 == '*');
        }
        for(int i = n-3; i >= 0; --i){
            char ch1 = s.charAt(i);
            for(int j = i+2; j < n; ++j){
                char ch2 = s.charAt(j);
                if((ch1 == '(' || ch1 == '*') && (ch2 == ')' || ch2 == '*')){
                    dp[i][j] = dp[i+1][j-1];
                }
                for(int k = i; k < j && !dp[i][j]; ++k){
                    dp[i][j] = dp[i][k] && dp[k+1][j];
                }
            }
        }
        return dp[0][n-1];
    }
}
