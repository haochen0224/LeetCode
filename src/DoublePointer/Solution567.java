package DoublePointer;

/**
 * 567. 字符串的排列
 * @Author Hao Chen
 * @Create 2022/9/13 17:23
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if(m > n){
            return false;
        }
        int[] cnt = new int[26];
        for(int i = 0; i < m; ++i){
            --cnt[s1.charAt(i)-'a'];
        }
        int left = 0;
        for(int right = 0; right < n; ++right){
            char ch = s2.charAt(right);
            ++cnt[ch-'a'];
            while(cnt[ch-'a'] > 0){
                --cnt[s2.charAt(left)-'a'];
                ++left;
            }
            if(right-left+1 == m){
                return true;
            }
        }
        return false;
    }
}
