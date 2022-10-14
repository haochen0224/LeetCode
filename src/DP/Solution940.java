package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 940. 不同的子序列 II
 * @Author Hao Chen
 * @Create 2022/10/13 13:59
 */
public class Solution940 {
    static final int MOD = (int)1e9+7;
    public int distinctSubseqII(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] cs = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int all = 1; //空集
        for(int i = 0; i < cs.length; ++i){
            int newCount = all;
            all = ((all+newCount)%MOD - map.getOrDefault(cs[i],0)%MOD + MOD)%MOD;
            map.put(cs[i],newCount);
        }
        return all-1;
    }
}
