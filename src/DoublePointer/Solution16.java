package DoublePointer;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * @Author Hao Chen
 * @Create 2022/7/27 22:24
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int first = 0;  first < n-2; ++first){
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            int second = first+1;
            int third = n-1;
            while(second < third){
                int sum = nums[first] + nums[second] + nums[third];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum-target) < Math.abs(min-target)){
                    min = sum;
                }
                if(sum > target){
                    while(second < third && nums[third] == nums[third-1]){
                        --third;
                    }
                    --third;
                }else{
                    while(second < third && nums[second] == nums[second+1]){
                        ++second;
                    }
                    ++second;
                }
            }
        }
        return min;
    }
}
