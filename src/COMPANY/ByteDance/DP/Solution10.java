package COMPANY.ByteDance.DP;

/**
 * 10. 正则表达式匹配
 * @Author Hao Chen
 * @Create 2022/8/8 20:29
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 1; i <= cp.length; ++i){
            if(cp[i-1] == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i = 1; i <= cs.length; ++i){
            for(int j = 1; j <= cp.length; ++j){
                if(cs[i-1] == cp[j-1] || cp[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(cp[j-1] == '*'){
                    if(cs[i-1] == cp[j-2] || cp[j-2] == '.'){
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
