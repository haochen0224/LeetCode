package Simulation;

/**
 * 1768. 交替合并字符串
 * @Author Hao Chen
 * @Create 2022/10/22 22:01
 */
public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        if(word1 == null || word2 == null){
            return word1 == null ? word2 : word1;
        }
        int n1 = word1.length(), n2 = word2.length();
        int p1 = 0, p2 = 0;
        StringBuilder res = new StringBuilder();
        while(p1 < n1 && p2 < n2){
            res.append(word1.charAt(p1++)).append(word2.charAt(p2++));
        }
        while(p1 < n1){
            res.append(word1.charAt(p1++));
        }
        while(p2 < n2){
            res.append(word2.charAt(p2++));
        }
        return res.toString();
    }
}
