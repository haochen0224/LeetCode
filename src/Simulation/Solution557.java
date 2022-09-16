package Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 557. 反转字符串中的单词 III
 * @Author Hao Chen
 * @Create 2022/9/16 16:35
 */
public class Solution557 {
    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        List<String> list = new ArrayList<>();
        for(int i = 0; i < sArr.length; ++i){
            list.add(reverse(sArr[i]));
        }
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < list.size(); ++i){
            res.append(list.get(i));
            if(i != list.size()-1){
                res.append(" ");
            }
        }
        return res.toString();
    }
    private String reverse(String s){
        char[] cs = s.toCharArray();
        int left = 0, right = s.length()-1;
        while(left < right){
            swap(cs,left++,right--);
        }
        return new String(cs);
    }
    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
