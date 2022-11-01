package Simulation;

/**
 * 1662. 检查两个字符串数组是否相等
 * @Author Hao Chen
 * @Create 2022/10/31 12:10
 */
public class Solution1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if(word1 == null || word2 == null){
            return false;
        }
        StringBuilder temp1 = new StringBuilder();
        StringBuilder temp2 = new StringBuilder();
        for(String word : word1){
            temp1.append(word);
        }
        for(String word : word2){
            temp2.append(word);
        }
        String s1 = temp1.toString();
        String s2 = temp2.toString();
        int p1 = 0, p2 = 0;
        while(p1 < s1.length() && p2 < s2.length()){
            if(s1.charAt(p1) == s2.charAt(p2)){
                ++p1;
                ++p2;
            }else{
                return false;
            }
        }
        return p1 == s1.length() && p2 == s2.length();
    }
}
