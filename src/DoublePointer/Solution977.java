package DoublePointer;

/**
 * 977. 有序数组的平方
 * @Author Hao Chen
 * @Create 2022/7/26 19:26
 */
public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length-1;
        int tail = res.length-1;
        while(left <= right){
            if(nums[left]*nums[left] < nums[right]*nums[right]){
                res[tail--] = nums[right]*nums[right];
                --right;
            }else{
                res[tail--] = nums[left]*nums[left];
                ++left;
            }
        }
        return res;
    }
}
