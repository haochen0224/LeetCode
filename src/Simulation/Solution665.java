package Simulation;

/**
 * 665. 非递减数列
 * @Author Hao Chen
 * @Create 2022/9/3 20:12
 */
public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n-1; ++i){
            int x = nums[i], y = nums[i+1];
            if(x > y){
                nums[i] = y; //nums[i] > nums[i+1]，则更改nums[i]为nums[i+1]，检查数组是否有序
                if(isSorted(nums)){
                    return true;
                }
                nums[i] = x; //如果无须，说明nums[i+1] < nums[i-1]，那么还原nums[i]，
                nums[i+1] = x; //并更改nums[i+1]为nums[i]（因为之前的遍历能保证nums[i]>nums[i-1]）
                return isSorted(nums);
            }
        }
        return true;
    }
    private boolean isSorted(int[] nums){
        int n = nums.length;
        for(int i = 1; i < n; ++i){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }
        return true;
    }
}
