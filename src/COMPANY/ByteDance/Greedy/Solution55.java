package COMPANY.ByteDance.Greedy;

/**
 * 55. 跳跃游戏
 * @Author Hao Chen
 * @Create 2022/8/5 17:45
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            if(i <= rightMost){
                rightMost = Math.max(rightMost,i+nums[i]);
                if(rightMost >= n-1){
                    return true;
                }
            }
        }
        return false;
    }
}
