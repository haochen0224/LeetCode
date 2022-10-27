package DoublePointer;

/**
 * 76. 最小覆盖子串
 * @Author Hao Chen
 * @Create 2022/10/27 0:16
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()){
            return "";
        }
        int[] have = new int[128];
        int[] need = new int[128];
        for(char ch : t.toCharArray()){
            ++need[ch];
        }
        int left = 0, right = 0;
        int min = s.length()+1;
        int start = 0;
        int cnt = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(need[ch] == 0){
                ++right;
                continue;
            }
            if(have[ch] < need[ch]){
                ++cnt;
            }
            ++have[ch];
            ++right;
            while(cnt == t.length()){
                if(right-left < min){
                    min = right - left;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if(need[leftChar] == 0){
                    ++left;
                    continue;
                }
                if(have[leftChar] == need[leftChar]){
                    --cnt;
                }
                --have[leftChar];
                ++left;
            }
        }
        return min == s.length()+1 ? "" : s.substring(start,start+min);
    }
}
