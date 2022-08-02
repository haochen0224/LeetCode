package Greedy;

/**
 * 45. 跳跃游戏 II
 * @Author Hao Chen
 * @Create 2022/8/1 18:20
 */
public class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int res = 0;
        int maxPosition = 0;
        for(int i = 0; i < n-1; ++i){
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if(i == end){
                end = maxPosition;
                ++res;
            }
        }
        return res;
    }
}
