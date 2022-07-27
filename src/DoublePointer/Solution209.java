package DoublePointer;

/**
 * 209. 长度最小的子数组
 * @Author Hao Chen
 * @Create 2022/7/24 13:46
 */
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(end < nums.length){
            sum += nums[end];
            while(sum >= target){
                res = Math.min(res,end-start+1);
                sum -= nums[start];
                ++start;
            }
            ++end;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
