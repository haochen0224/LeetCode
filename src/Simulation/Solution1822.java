package Simulation;

/**
 * 1822. 数组元素积的符号
 * @Author Hao Chen
 * @Create 2022/10/26 12:40
 */
public class Solution1822 {
    public int arraySign(int[] nums) {
        int nagetiveCount = 0;
        for(int num : nums){
            if(num == 0){
                return 0;
            }else if(num < 0){
                ++nagetiveCount;
            }
        }
        return nagetiveCount%2 == 0 ? 1 : -1;
    }
}
