package Simulation;

/**
 * 189. 轮转数组
 * @Author Hao Chen
 * @Create 2022/9/12 18:24
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[] nums,int left,int right){
        while(left < right){
            swap(nums,left++,right--);
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
