package Greedy;

/**
 * 915. 分割数组
 * @Author Hao Chen
 * @Create 2022/10/23 13:45
 */
public class Solution915 {
    public int partitionDisjoint(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] minRight = new int[n];
        minRight[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; --i){
            minRight[i] = Math.min(nums[i],minRight[i+1]);
        }
        int maxLeft = 0;
        for(int i = 0; i < n-1; ++i){
            maxLeft = Math.max(maxLeft,nums[i]);
            if(maxLeft <= minRight[i+1]){
                return i+1;
            }
        }
        return -1;
    }
}
