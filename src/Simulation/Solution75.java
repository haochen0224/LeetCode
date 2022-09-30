package Simulation;

/**
 * 75. 颜色分类
 * @Author Hao Chen
 * @Create 2022/9/29 13:41
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int red = -1, blue = n;
        for(int i = 0; i < n; ++i){
            while(i < blue && nums[i] == 2){
                swap(nums,i,--blue);
            }
            if(nums[i] == 0){
                swap(nums,i,++red);
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
