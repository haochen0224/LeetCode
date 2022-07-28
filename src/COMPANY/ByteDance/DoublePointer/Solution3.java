package COMPANY.ByteDance.DoublePointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * @Author Hao Chen
 * @Create 2022/7/21 13:58
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); //维护[left,right]范围内的字符
        int right = -1;
        int res = 0;
        for(int left = 0; left < s.length(); ++left){
            if(left != 0){
                set.remove(s.charAt(left-1)); //left右移之后在set中删除set维护范围之外的字符
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
