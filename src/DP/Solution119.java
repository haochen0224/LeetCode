package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * @Author Hao Chen
 * @Create 2022/10/16 13:11
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0){
            return null;
        }
        List<List<Integer>> total = new ArrayList<>();
        for(int i = 0; i <= rowIndex; ++i){
            List<Integer> layer = new ArrayList<>();
            for(int j = 0; j <= i; ++j){
                if(j == 0 || j == i){
                    layer.add(1);
                }else if(i > 0){
                    layer.add(total.get(i-1).get(j-1) + total.get(i-1).get(j));
                }
            }
            total.add(layer);
        }
        return total.get(rowIndex);
    }
}
