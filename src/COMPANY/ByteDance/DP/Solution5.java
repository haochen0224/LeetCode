package COMPANY.ByteDance.DP;

/**
 * 5. 最长回文子串
 * @Author Hao Chen
 * @Create 2022/7/22 14:52
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        //枚举字串长度
        for(int subLen = 2; subLen <= len; ++subLen){
            //枚举左边界i
            for(int i = 0; i < len; ++i){
                //右边界j
                int j = i + subLen - 1;
                if(j >= len){
                    break;
                }
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i+1 <= 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
