package COMPANY.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * @Author Hao Chen
 * @Create 2022/7/23 15:37
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> a[0]-b[0]);
        int i = 0;
        List<int[]> res = new ArrayList<>();
        while(i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < intervals.length-1 && right >= intervals[i+1][0]){
                ++i;
                right = Math.max(right,intervals[i][1]);
            }
            res.add(new int[]{left,right});
            ++i;
        }
        return res.toArray(new int[0][]);
    }
}
