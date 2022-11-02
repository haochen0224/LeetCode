package Simulation;

/**
 * 1668. 最大重复子字符串
 * @Author Hao Chen
 * @Create 2022/11/2 18:41
 */
public class Solution1668 {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        String s = word;
        while(sequence.contains(s)){
            ++res;
            s += word;
        }
        return res;
    }
}
