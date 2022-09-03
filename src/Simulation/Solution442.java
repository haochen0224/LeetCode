package Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * @Author Hao Chen
 * @Create 2022/8/31 18:23
 */
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
        for(int i = 0; i < nums.length; ++i){
            while(nums[i] != nums[nums[i]-1]){
                swap(nums,nums[i]-1,i);
            }
        }
        for(int i = 0; i < nums.length; ++i){
            if(nums[i]-1 != i){
                res.add(nums[i]);
            }
        }
        return res;
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
