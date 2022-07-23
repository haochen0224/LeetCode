package COMPANY.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @Author Hao Chen
 * @Create 2022/7/22 15:17
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        Arrays.sort(nums);
        for(int first = 0; first < n-2; ++first){
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            int target = -nums[first];
            int third = n-1;
            for(int second = first+1; second < n-1; ++second){
                if(second > first + 1 && nums[second] == nums[second-1]){
                    continue;
                }
                while(second < third && nums[third] + nums[second] > target){
                    --third;
                }
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == target){
                    res.add(Arrays.asList(nums[first],nums[second],nums[third]));
                }
            }
        }
        return res;
    }
}
