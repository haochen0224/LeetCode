package Simulation;

/**
 * 628. 三个数的最大乘积
 * @Author Hao Chen
 * @Create 2022/9/30 20:40
 */
public class Solution628 {
    public int maximumProduct(int[] nums) {
        if(nums == null){
            return 0;
        }
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max2;
        for(int x : nums){
            if(x < min1){
                min2 = min1;
                min1 = x;
            }else if(x < min2){
                min2 = x;
            }
            if(x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if(x > max2){
                max3 = max2;
                max2 = x;
            }else if(x > max3){
                max3 = x;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}
