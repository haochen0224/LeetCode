package COMPANY.ByteDance.Other;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * @Author Hao Chen
 * @Create 2022/8/1 17:00
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int res = 0;
        for(int curNum : set){
            if(!set.contains(curNum-1)){
                int curLength = 1;
                while(set.contains(curNum+1)){
                    curNum += 1;
                    curLength += 1;
                }
                res = Math.max(res,curLength);
            }
        }
        return res;
    }
}
