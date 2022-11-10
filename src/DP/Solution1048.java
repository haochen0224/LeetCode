package DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1048. 最长字符串链
 * @Author Hao Chen
 * @Create 2022/11/10 17:23
 */
public class Solution1048 {
    public int longestStrChain(String[] words) {
        if(words == null || words.length == 0){
            return 0;
        }
        int n = words.length;
        Arrays.sort(words,Comparator.comparingInt(String::length));
        int[] dp = new int[n];
        int res = 1;
        for(int i = 0; i < n; ++i){
            dp[i] = 1;
            for(int j = 0; j < i; ++j){
                if(isMatch(words[j],words[i])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    private boolean isMatch(String a,String b){
        if(a.length() != b.length()-1){
            return false;
        }
        int i = 0;
        for(int j = 0; i < a.length() && j < b.length(); ++j){
            if(a.charAt(i) == b.charAt(j)){
                ++i;
            }
        }
        return i == a.length();
    }
}
