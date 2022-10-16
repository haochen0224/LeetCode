package Simulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 1647. 字符频次唯一的最小删除次数
 * @Author Hao Chen
 * @Create 2022/10/15 19:29
 */
public class Solution1647 {
    public int minDeletions(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] freq = new int[26];
        for(char ch : cs){
            ++freq[ch-'a'];
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int cur : freq){
            while(cur > 0 && !set.add(cur)){
                --cur;
                ++res;
            }
        }
        return res;
    }
}
