package COMPANY.ByteDance;

/**
 * 41. 缺失的第一个正数
 * @Author Hao Chen
 * @Create 2022/7/26 23:45
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; ++i){
            while(nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for(int i = 0; i < len; ++i){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return len+1;
    }
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
