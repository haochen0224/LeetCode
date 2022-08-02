package COMPANY.ByteDance.DoublePointer;

/**
 * 76. 最小覆盖子串
 * @Author Hao Chen
 * @Create 2022/8/1 17:54
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        if(s == null || s == "" || t == null || t == "" || s.length() < t.length()){
            return "";
        }
        int[] need = new int[128];
        int[] have = new int[128];
        for(int i = 0; i < t.length(); ++i){
            need[t.charAt(i)]++;
        }
        int left = 0, right = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(need[ch] == 0){
                ++right;
                continue;
            }
            if(have[ch] < need[ch]){
                ++count;
            }
            have[ch]++;
            ++right;
            while(count == t.length()){
                if(right-left < min){
                    min = right-left;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if(need[leftChar] == 0){
                    ++left;
                    continue;
                }
                if(have[leftChar] == need[leftChar]){
                    --count;
                }
                have[leftChar]--;
                ++left;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start,start+min);
    }
}
