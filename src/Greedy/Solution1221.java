package Greedy;

import java.util.Arrays;

/**
 * 1221. 分割平衡字符串
 * @Author Hao Chen
 * @Create 2022/10/4 17:56
 */
public class Solution1221 {
    public int balancedStringSplit(String s) {
        if(s == null){
            return 0;
        }
        int[] freq = new int[2];
        int i = 0;
        int n = s.length();
        int res = 0;
        while(i < n){
            Arrays.fill(freq,0);
            while(freq[0] == 0 || freq[0] != freq[1]){
                if(s.charAt(i) == 'L'){
                    ++freq[0];
                }else{
                    ++freq[1];
                }
                ++i;
            }
            ++res;
        }
        return res;
    }
}
