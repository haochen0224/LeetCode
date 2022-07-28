package COMPANY.ByteDance.Other;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * @Author Hao Chen
 * @Create 2022/7/21 13:17
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
