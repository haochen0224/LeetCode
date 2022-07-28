package DoublePointer;

/**
 * 713. 乘积小于 K 的子数组
 * @Author Hao Chen
 * @Create 2022/7/28 18:07
 */
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int mul = 1;
        int res = 0;
        while(right < nums.length){
            mul *= nums[right];
            while(left <= right && mul >= k){
                mul /= nums[left];
                ++left;
            }
            res += right-left+1; //新增的符合条件的子数组，首先(left,right]的所有单个数都满足，个数为right-left,
                                 // 然后(left,right]组成的子数组也满足，因此总个数为right-left+1
            ++right;
        }
        return res;
    }
}
