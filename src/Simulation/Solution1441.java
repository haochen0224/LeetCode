package Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 * @Author Hao Chen
 * @Create 2022/10/14 12:27
 */
public class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        if(target == null || target.length == 0){
            return null;
        }
        List<String> res = new ArrayList<>();
        int prev = 0;
        for(int num : target){
            for(int i = 0; i < num-prev-1; ++i){ //不需要关心中间缺失的数是什么，只需要知道需要添加多少对"Push""Pop"
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");
            prev = num;
        }
        return res;
    }
}
