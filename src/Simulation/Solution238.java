package Simulation;

/**
 * 238. 除自身以外数组的乘积
 * @Author Hao Chen
 * @Create 2022/8/31 17:31
 */
public class Solution238 {
    //O(1)空间复杂度
    public int[] productExceptSelf(int[] nums) {
        if(nums == null){
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; ++i){
            res[i] = nums[i-1] * res[i-1];
        }
        int R = 1;
        for(int i = n-1; i >= 0; --i){
            res[i] = res[i] * R;
            R *= nums[i];
        }
        return res;
    }
//    O(n) 空间复杂度
//    public int[] productExceptSelf(int[] nums) {
//        if(nums == null){
//            return new int[0];
//        }
//        int n = nums.length;
//        int[] L = new int[n];
//        int[] R = new int[n];
//        L[0] = 1;
//        for(int i = 1; i < n; ++i){
//            L[i] = nums[i-1] * L[i-1];
//        }
//        R[n-1] = 1;
//        for(int i = n-2; i >= 0; --i){
//            R[i] = nums[i+1] * R[i+1];
//        }
//        int[] res = new int[n];
//        for(int i = 0; i < n; ++i){
//            res[i] = L[i] * R[i];
//        }
//        return res;
//    }
}
