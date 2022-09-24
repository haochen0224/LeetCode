package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * @Author Hao Chen
 * @Create 2022/9/23 16:36
 */
public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] last = new int[26];
        for(int i = 0; i < s.length(); ++i){
            last[s.charAt(i)-'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); ++i){
            end = Math.max(end,last[s.charAt(i)-'a']);
            if(i == end){
                res.add(end-start+1);
                start = end+1;
            }
        }
        return res;
    }
}
