package BackTracking;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * @Author Hao Chen
 * @Create 2022/10/20 18:09
 */
public class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0) return false;
        Arrays.sort(nums);
        int left = 0, right = n-1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            ++left;
            --right;
        }
        int target = sum/k;
        int[] bucket = new int[k];
        return dfs(nums,0,bucket,target);
    }
    private boolean dfs(int[] nums,int index,int[] bucket,int target){
        if(index == nums.length){
            return true;
        }
        for(int i = 0; i < bucket.length; ++i){
            if(i > 0 && bucket[i] == bucket[i-1]){
                continue;
            }
            if(bucket[i] + nums[index] > target){
                continue;
            }
            bucket[i] += nums[index];
            if(dfs(nums,index+1,bucket,target)){
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;
    }
}
