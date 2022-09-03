package Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * @Author Hao Chen
 * @Create 2022/9/1 17:47
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0){
            return res;
        }
        for(int i = 0; i < numRows; ++i){
            List<Integer> layer = new ArrayList<>();
            for(int j = 0; j <= i; ++j){
                if(j == 0 || j == i){
                    layer.add(1);
                }else{
                    layer.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(layer);
        }
        return res;
    }
}
