package Math;

/**
 * 754. 到达终点数字
 * @Author Hao Chen
 * @Create 2022/11/3 20:27
 */
public class Solution754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while(target > 0){
            ++k;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}
