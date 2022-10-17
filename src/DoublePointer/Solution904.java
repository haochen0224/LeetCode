package DoublePointer;

/**
 * 904. 水果成篮
 * @Author Hao Chen
 * @Create 2022/10/16 12:54
 */
public class Solution904 {
    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2){
            return fruits.length;
        }
        int n = fruits.length;
        int res = 2;
        int left = 0, right = 0;
        int[] freq = new int[n];
        int cnt = 0;
        while(right < n){
            ++freq[fruits[right]];
            if(freq[fruits[right]] == 1){
                ++cnt;
            }
            ++right;
            while(cnt > 2){
                --freq[fruits[left]];
                if(freq[fruits[left]] == 0){
                    --cnt;
                }
                ++left;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
