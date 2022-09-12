package Simulation;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * @Author Hao Chen
 * @Create 2022/9/11 23:56
 */
public class Offer58 {
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length()-1;
        int i = j;
        StringBuffer res = new StringBuffer();
        while(i >= 0){
            while((i >= 0) && s.charAt(i) != ' ') --i;
            res.append(" " + s.substring(i+1,j+1));
            while((i >= 0) && s.charAt(i) == ' ') --i;
            j = i;
        }
        return res.toString().trim();
    }
}
