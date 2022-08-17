package DP;

/**
 * 10. 正则表达式匹配
 * @Author Hao Chen
 * @Create 2022/8/17 17:39
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];//s串前i个字符能否和p串前j个字符匹配
        dp[0][0] = true;
        //s串长度为0，因此只能将'*'（位置为i-1）前面的字符匹配0次，即跳过'*'前的字符（位置为i-2），判断p[i-3]
        //因此dp[0][i]继承dp[0][i-2]
        for(int i = 1; i <= cp.length; ++i){
            if(cp[i-1] == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i = 1; i <= cs.length; ++i){
            for(int j = 1; j <= cp.length; ++j){
                if(cs[i-1] == cp[j-1] || cp[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];//末尾字符匹配成功，消灭掉这两个字符，判断前i-1和前j-1个
                }else if(cp[j-1] == '*'){
                    if(cs[i-1] == cp[j-2] || cp[j-2] == '.'){ //p串'*'前的字符能够和s串末尾字符匹配，此时可以匹配0次或多次
                        dp[i][j] = dp[i][j-2] || dp[i-1][j]; //若匹配0次，则跳过p[j-2]，判断p[j-3]，那么dp[i][j] = dp[i][j-2]
                        //若匹配多次，那么消灭掉s[i-1]，判断s[i-2]，那么dp[i][j] = dp[i-1][j]
                    }else{
                        dp[i][j] = dp[i][j-2]; //p串'*'前的字符不能和s串末尾字符匹配，此时只能匹配0次
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
