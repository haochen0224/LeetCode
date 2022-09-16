package DoublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * @Author Hao Chen
 * @Create 2022/9/15 17:53
 */
public class Offer57 {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j){
            if(s == target){
                int[] ans = new int[j-i+1];
                for(int k = i; k <= j; ++k){
                    ans[k-i] = k;
                }
                res.add(ans);
            }
            if(s >= target){
                s -= i;
                ++i;
            }else{
                ++j;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
