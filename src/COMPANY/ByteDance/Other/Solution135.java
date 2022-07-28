package COMPANY.ByteDance.Other;

/**
 * 135. 分发糖果
 * @Author Hao Chen
 * @Create 2022/7/27 19:44
 */
public class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n]; //根据i位置左边的rating得出的i位置需要的糖果数量
        int[] right = new int[n]; //根据i位置右边的rating得出的i位置需要的糖果数量
        for(int i = 0; i < n; ++i){
            if(i > 0 && ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }else{
                left[i] = 1;
            }
        }
        int res = 0;
        for(int i = n-1; i >= 0; --i){
            if(i < n-1 && ratings[i] > ratings[i+1]){
                right[i] = right[i+1] + 1;
            }else{
                right[i] = 1;
            }
            res += Math.max(left[i],right[i]);
        }
        return res;
    }
}
