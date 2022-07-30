package COMPANY.ByteDance.Other;

/**
 * 31. 下一个排列
 * @Author Hao Chen
 * @Create 2022/7/24 19:24
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        //选择一个尽量靠右边的小数
        while(i >= 0 && nums[i] >= nums[i+1]){
            --i;
        }
        //选择一个尽量小的大数
        if(i >= 0){
            int j = nums.length-1;
            while(j >= 0 && nums[i] >= nums[j]){
                --j;
            }
            //交换小数和大数
            swap(nums,i,j);
        }
        //交换后数组右侧一定是降序的
        //保持交换后的数组右侧升序（升序就是字典序最小的一种排列）
        reverse(nums,i+1);
    }
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums,int start){
        int left = start, right = nums.length-1;
        while(left < right){
            swap(nums,left,right);
            ++left;
            --right;
        }
    }
}
