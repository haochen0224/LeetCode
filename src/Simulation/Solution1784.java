package Simulation;

/**
 * 1784. 检查二进制字符串字段
 * @Author Hao Chen
 * @Create 2022/10/2 12:42
 */
public class Solution1784 {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
