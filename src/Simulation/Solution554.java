package Simulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. 砖墙
 * @Author Hao Chen
 * @Create 2022/9/19 19:25
 */
public class Solution554 {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0){
            return 0;
        }
        List<Integer> first = wall.get(0);
        int totalLen = 0;
        for(int len : first){
            totalLen += len;
        }
        Map<Integer,Integer> endAt = new HashMap<>();
        int numOfRows = 0;
        for(List<Integer> row : wall){
            numOfRows++;
            int pre = 0;
            for(int brick : row){
                if(pre+brick == totalLen){
                    break;
                }
                endAt.put(pre+brick,endAt.getOrDefault(pre+brick,0)+1);
                pre = pre+brick;
            }
        }
        int maxFreq = 0;
        for(int freq : endAt.values()){
            maxFreq = Math.max(maxFreq,freq);
        }
        return numOfRows-maxFreq;
    }
}
