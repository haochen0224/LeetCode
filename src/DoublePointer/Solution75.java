package DoublePointer;

/**
 * 75. 颜色分类
 * @Author Hao Chen
 * @Create 2022/9/14 21:17
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        int left = -1, right = nums.length;
        for(int i = 0; i < nums.length; ++i){
            while(i < right && nums[i] == 2){
                swap(nums,i,--right);
            }
            if(nums[i] == 0){
                swap(nums,i,++left);
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
