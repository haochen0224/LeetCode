package DoublePointer;

/**
 * 283. 移动零
 * @Author Hao Chen
 * @Create 2022/7/26 18:03
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                swap(nums,left,right);
                ++left;
            }
            ++right;
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
