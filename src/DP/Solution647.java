package DP;

/**
 * 647. 回文子串
 * @Author Hao Chen
 * @Create 2022/9/14 18:41
 */
public class Solution647 {
    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for(int j = 0; j < n; ++j){
            for(int i = 0; i <= j; ++i){
                if(cs[i] == cs[j] && (j-i+1 <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    ++res;
                }
            }
        }
        return res;
    }
}
