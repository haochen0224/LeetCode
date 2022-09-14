package Simulation;


/**
 * 66. 加一
 * @Author Hao Chen
 * @Create 2022/9/13 20:18
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; --i){
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0){
                return digits;
            }
        }
        if(digits[0] == 0){
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }
}
