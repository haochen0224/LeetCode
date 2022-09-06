package Simulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * @Author Hao Chen
 * @Create 2022/9/5 18:03
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int res = 0;
        for(int curNum : set){
            if(!set.contains(curNum-1)){
                int curLen = 1;
                while(set.contains(curNum+1)){
                    curNum += 1;
                    curLen += 1;
                }
                res = Math.max(res,curLen);
            }
        }
        return res;
    }
}
