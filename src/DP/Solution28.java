package DP;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * @Author Hao Chen
 * @Create 2022/8/15 17:34
 */
public class Solution28 {
    static int[][] dp;
    public static void KMP(String needle){
        int m = needle.length();
        dp = new int[m][256];
        dp[0][needle.charAt(0)] = 1;
        int X = 0;
        for(int i = 1; i < m; ++i){
            for(int c = 0; c < 256; ++c){
                if(needle.charAt(i) == c){
                    dp[i][c] = i+1;
                }else{
                    dp[i][c] = dp[X][c];
                }
            }
            X = dp[X][needle.charAt(i)];
        }
    }
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        KMP(needle);
        int j = 0;
        for(int i = 0; i < n; ++i){
            j = dp[j][haystack.charAt(i)];
            if(j == m){
                return i-m+1;
            }
        }
        return -1;
    }
    // public int strStr(String haystack, String needle) {
    //     if(needle.length() == 0 || needle == null){
    //         return 0;
    //     }
    //     int n = haystack.length();
    //     int m = needle.length();
    //     for(int i = 0; i+m <= n; ++i){
    //         boolean flag = true;
    //         for(int j = 0; j < m; ++j){
    //             if(haystack.charAt(i+j) != needle.charAt(j)){
    //                 flag = false;
    //                 break;
    //             }
    //         }
    //         if(flag){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
}
