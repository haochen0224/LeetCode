package DoublePointer;

/**
 * 27. 移除元素
 * @Author Hao Chen
 * @Create 2022/7/26 18:34
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for(int right = 0; right < nums.length; ++right){
            if(nums[right] != val){
                nums[left] = nums[right];
                ++left;
            }
        }
        return left;
    }
}
