package Other;

import java.util.HashMap;
import java.util.Map;

/**
 * 1553. 吃掉 N 个橘子的最少天数
 * @Author Hao Chen
 * @Create 2022/8/30 18:20
 */
public class Solution1553 {
    Map<Integer,Integer> map = new HashMap<>(); // key 为橘子数量， value为吃掉橘子的最少天数
    public int minDays(int n) {
        if(n <= 1){
            return n;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        //操作1：一天吃一个橘子，把橘子数量变为2的整数倍，再用一天吃掉n/2个橘子；（天数为 n%2 + 1 + minDays(n/2)）
        //操作2：一天吃一个橘子，把橘子数量变为3的整数倍，再用一天吃掉2n/3个橘子；（天数为n%3 + 1 + minDays(n/3)）
        //取操作1和操作2的最小值
        map.put(n,Math.min(n%2 + 1 + minDays(n/2),n%3 + 1 + minDays(n/3)));
        return map.get(n);
    }
}
