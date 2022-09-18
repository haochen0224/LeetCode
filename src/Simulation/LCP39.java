package Simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * LCP 39. 无人机方阵
 * @Author Hao Chen
 * @Create 2022/9/17 14:52
 */
public class LCP39 {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int n = target.length;
        int m = target[0].length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                map.put(source[i][j],map.getOrDefault(source[i][j],0)+1);
            }
        }
        int res = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(!map.containsKey(target[i][j]) || map.get(target[i][j]) == 0){
                    ++res;
                }else{
                    int count = map.get(target[i][j]);
                    map.put(target[i][j],--count);
                }
            }
        }
        return res;
    }
}
