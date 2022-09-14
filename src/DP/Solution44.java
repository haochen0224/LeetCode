package DP;

/**
 * 44. 通配符匹配
 * @Author Hao Chen
 * @Create 2022/9/13 17:48
 */
public class Solution44 {
    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        boolean[][] dp = new boolean[cs.length+1][cp.length+1];
        dp[0][0] = true;
        for(int i = 1; i <= cp.length; ++i){
            if(cp[i-1] == '*'){
                dp[0][i] = true;
            }else{
                break; // '*'只能匹配它所在位置的任意字符串，不能处理它之前或之后的字符串
            }
        }
        for(int i = 1; i <= cs.length; ++i){
            for(int j = 1; j <= cp.length; ++j){
                if(cs[i-1] == cp[j-1] || cp[j-1] == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(cp[j-1] == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j]; //不使用'*', dp[i][j] = dp[i][j-1]，使用'*'，dp[i][j] = dp[i-1][j]
                }
            }
        }
        return dp[cs.length][cp.length];
    }
}
