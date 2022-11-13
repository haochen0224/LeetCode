package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 1182. 与目标颜色间的最短距离
 * @Author Hao Chen
 * @Create 2022/11/13 17:52
 */
public class Solution1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        if(colors == null || colors.length == 0){
            return new ArrayList<>();
        }
        int n = colors.length;
        int[][] front = new int[n][3];
        int[][] back = new int[n][3];
        front[0][0] = front[0][1] = front[0][2] = Integer.MAX_VALUE;
        front[0][colors[0]-1] = 0;
        for(int i = 1; i < n; ++i){
            front[i][0] = front[i-1][0] == Integer.MAX_VALUE ? Integer.MAX_VALUE : front[i-1][0] + 1;
            front[i][1] = front[i-1][1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : front[i-1][1] + 1;
            front[i][2] = front[i-1][2] == Integer.MAX_VALUE ? Integer.MAX_VALUE : front[i-1][2] + 1;
            front[i][colors[i]-1] = 0;
        }
        back[n-1][0] = back[n-1][1] = back[n-1][2] = Integer.MAX_VALUE;
        back[n-1][colors[n-1]-1] = 0;
        for(int i = n-2; i >= 0; --i){
            back[i][0] = back[i+1][0] == Integer.MAX_VALUE ? Integer.MAX_VALUE : back[i+1][0] + 1;
            back[i][1] = back[i+1][1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : back[i+1][1] + 1;
            back[i][2] = back[i+1][2] == Integer.MAX_VALUE ? Integer.MAX_VALUE : back[i+1][2] + 1;
            back[i][colors[i]-1] = 0;
        }
        List<Integer> res = new ArrayList<>();
        for(int[] query : queries){
            int index = query[0], color = query[1]-1;
            int curRes = Math.min(front[index][color],back[index][color]);
            if(curRes == Integer.MAX_VALUE){
                curRes = -1;
            }
            res.add(curRes);
        }
        return res;
    }
}
