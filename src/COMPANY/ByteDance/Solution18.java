package COMPANY.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * @Author Hao Chen
 * @Create 2022/7/22 15:36
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || len < 4){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len-3; ++i){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            if((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }
            if((long)nums[i] + nums[len-1] + nums[len-2] + nums[len-3] < target){
                continue;
            }
            for(int j = i+1; j < len-2; ++j){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if((long)nums[i] + nums[j] + nums[j+1] +nums[j+2] > target){
                    break;
                }
                if((long)nums[i] + nums[j] + nums[len-1] + nums[len-2] < target){
                    continue;
                }
                int left = j+1;
                int right = len-1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left < right && nums[left] == nums[left+1]){
                            ++left;
                        }
                        ++left;
                        while(left < right && nums[right] == nums[right-1]){
                            --right;
                        }
                        --right;
                    }else if(sum < target){
                        ++left;
                    }else{
                        --right;
                    }
                }
            }
        }
        return res;
    }
}
