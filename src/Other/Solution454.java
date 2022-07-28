package Other;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * @Author Hao Chen
 * @Create 2022/7/27 22:07
 */
public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : nums1){
            for(int b : nums2){
                map.put(a+b,map.getOrDefault(a+b,0)+1);
            }
        }
        int res = 0;
        for(int c : nums3){
            for(int d : nums4){
                if(map.containsKey(-c-d)){
                    res += map.get(-c-d);
                }
            }
        }
        return res;
    }
}
