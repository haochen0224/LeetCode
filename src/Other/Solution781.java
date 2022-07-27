package Other;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. 森林中的兔子
 * @Author Hao Chen
 * @Create 2022/7/26 22:17
 */
public class Solution781 {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int ans : answers){
            map.put(ans,map.getOrDefault(ans,0)+1);
        }
        int res = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int x = entry.getValue(), y = entry.getKey();
            res += (x+y)/(y+1) * (y+1);
        }
        return res;
    }
}
