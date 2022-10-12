package Greedy;

/**
 * 1014. 最佳观光组合
 * @Author Hao Chen
 * @Create 2022/10/11 18:35
 */
public class Solution1014 {
    public int maxScoreSightseeingPair(int[] values) {
        if(values == null || values.length == 0){
            return 0;
        }
        int mx = values[0];
        int res = 0;
        for(int j = 1; j < values.length; ++j){
            res = Math.max(res,mx+values[j]-j);
            mx = Math.max(mx,values[j]+j);
        }
        return res;
    }
}
