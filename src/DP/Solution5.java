package DP;

/**
 * 5. 最长回文子串
 * @Author Hao Chen
 * @Create 2022/8/16 17:23
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int startIndex = 0;
        char[] charArray = s.toCharArray();
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        for(int subLen = 2; subLen <= len; ++subLen){
            for(int i = 0; i < len; ++i){
                int j = i + subLen - 1;
                if(j >= len){
                    break;
                }
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i+1 <= 2){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex,startIndex+maxLen);
    }
}
