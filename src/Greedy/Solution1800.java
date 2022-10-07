package Greedy;

/**
 * 1800. 最大升序子数组和
 * @Author Hao Chen
 * @Create 2022/10/6 12:11
 */
public class Solution1800 {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        int i = 0;
        while(i < n){
            int cur = nums[i];
            while(i+1 < n && nums[i+1] > nums[i]){
                cur += nums[i+1];
                ++i;
            }
            res = Math.max(res,cur);
            ++i;
        }
        return res;
    }
}
