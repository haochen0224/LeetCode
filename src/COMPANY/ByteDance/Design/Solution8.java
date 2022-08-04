package COMPANY.ByteDance.Design;

import java.util.HashMap;
import java.util.Map;

/**
 * 8. 字符串转换整数 (atoi)
 * @Author Hao Chen
 * @Create 2022/8/3 20:30
 */
public class Solution8 {
}
class Solution {
    public int myAtoi(String s) {
        Automation am = new Automation();
        for(int i = 0; i < s.length(); ++i){
            am.get(s.charAt(i));
        }
        return (int)(am.sign * am.res);
    }
}
class Automation{
    int sign = 1;
    long res = 0;
    String state = "start";
    Map<String,String[]> map = new HashMap<String,String[]>(){{
        put("start",new String[]{"start","signed","inNumber","end"});
        put("signed",new String[]{"end","end","inNumber","end"});
        put("inNumber",new String[]{"end","end","inNumber","end"});
        put("end",new String[]{"end","end","end","end"});
    }};
    public void get(char ch){
        state = map.get(state)[getNext(ch)];
        if("inNumber".equals(state)){
            res = res * 10 + ch - '0';
            res = sign == 1 ? Math.min(res,(long)Integer.MAX_VALUE) : Math.min(res,-(long)Integer.MIN_VALUE);
        }else if("signed".equals(state)){
            sign = ch == '+' ? 1 : -1;
        }
    }
    private int getNext(char ch){
        if(ch == ' '){
            return 0;
        }
        if(ch == '+' || ch == '-'){
            return 1;
        }
        if(Character.isDigit(ch)){
            return 2;
        }
        return 3;
    }
}