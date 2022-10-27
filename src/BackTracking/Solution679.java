package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 679. 24 点游戏
 * @Author Hao Chen
 * @Create 2022/10/26 18:40
 */
public class Solution679 {
    double target = 24;
    double epislon = 1e-6;
    public boolean judgePoint24(int[] cards) {
        return helper(new double[]{cards[0],cards[1],cards[2],cards[3]});
    }
    private boolean helper(double[] nums){
        if(nums.length == 1){
            return Math.abs(nums[0]-target) < epislon;
        }
        int n = nums.length;
        //每次选两个数，把它们的运算结果和其他未运算的数一起加入next数组，对next数组进行递归
        for(int i = 0; i < n; ++i){
            for(int j = i+1; j < n; ++j){
                double[] next = new double[n-1];
                int index = 0;
                for(int k = 0; k < n; ++k){
                    if(k != i && k != j){ //把其他未参与运算的数加入next数组
                        next[index++] = nums[k];
                    }
                }
                for(double num : calculate(nums[i],nums[j])){ //把nums[i]和nums[j]的运算结果加入next数组
                    next[next.length-1] = num;
                    if(helper(next)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private List<Double> calculate(double a,double b){
        List<Double> res = new ArrayList<>();
        res.add(a+b);
        res.add(a-b);
        res.add(b-a);
        res.add(a*b);
        if(!(Math.abs(b) < epislon)) res.add(a/b);
        if(!(Math.abs(a) < epislon)) res.add(b/a);
        return res;
    }
}
