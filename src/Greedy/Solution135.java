package Greedy;

/**
 * 135. 分发糖果
 * @Author Hao Chen
 * @Create 2022/9/29 13:14
 */
public class Solution135 {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; ++i){
            if(i > 0 && ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 1;
            }
        }
        int res = 0;
        for(int i = n-1; i >= 0; --i){
            if(i < n-1 && ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }else{
                right[i] = 1;
            }
        }
        for(int i = 0; i < n; ++i){
            res += Math.max(left[i],right[i]);
        }
        return res;
    }
}
