package DoublePointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * @Author Hao Chen
 * @Create 2022/7/26 19:59
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int right = -1;
        int res = 0;
        Set<Character> set = new HashSet<>();
        for(int left = 0; left < s.length(); ++left){
            char ch = s.charAt(left);
            if(left > 0){
                set.remove(s.charAt(left-1));
            }
            while(right+1 < s.length() && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                ++right;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
