package DP;

/**
 * 376. 摆动序列
 * @Author Hao Chen
 * @Create 2022/10/22 23:34
 */
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        int res = 1;
        for(int i = 1; i < n; ++i){
            if(nums[i] > nums[i-1]){
                up[i] = Math.max(up[i-1],down[i-1]+1);
                down[i] = down[i-1];
            }else if(nums[i] < nums[i-1]){
                down[i] = Math.max(down[i-1],up[i-1]+1);
                up[i] = up[i-1];
            }else{
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[n-1],down[n-1]);
    }
}
