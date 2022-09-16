package Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * @Author Hao Chen
 * @Create 2022/9/16 16:48
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            list.add(String.valueOf(nums[i]));
        }
        list.sort((a,b) -> (a+b).compareTo(b+a));
        StringBuffer res = new StringBuffer();
        for(String s : list){
            res.append(s);
        }
        return res.toString();
    }
}
