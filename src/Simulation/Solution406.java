package Simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * @Author Hao Chen
 * @Create 2022/9/13 20:42
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a, b) -> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);
        List<int[]> list = new ArrayList<>();
        for(int[] person : people){
            if(list.size() <= person[1]){
                list.add(person);
            }else{
                list.add(person[1],person);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
