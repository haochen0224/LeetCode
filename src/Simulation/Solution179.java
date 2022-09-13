package Simulation;

import java.util.Arrays;

/**
 * 179. 最大数
 * @Author Hao Chen
 * @Create 2022/9/12 17:46
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];
        for(int i = 0; i < n; ++i){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,(a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        });
        StringBuffer res = new StringBuffer();
        for(String s : str){
            res.append(s);
        }
        int start = 0;
        while(start < n-1 && res.charAt(start) == '0') ++start;
        return res.substring(start);
    }
}
