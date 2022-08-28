package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * @Author Hao Chen
 * @Create 2022/8/27 18:39
 */
public class Solution17 {
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        Map<Integer,String> map = new HashMap<Integer,String>(){{
            put(2,"abc");
            put(3,"def");
            put(4,"ghi");
            put(5,"jkl");
            put(6,"mno");
            put(7,"pqrs");
            put(8,"tuv");
            put(9,"wxyz");
        }};
        dfs(0,digits,map,new StringBuffer());
        return res;
    }
    private void dfs(int startIndex,String digits, Map<Integer,String> map,StringBuffer path){
        if(startIndex == digits.length()){
            res.add(path.toString());
            return;
        }
        int number = digits.charAt(startIndex)-'0';
        String letters = map.get(number);
        for(int i = 0; i < letters.length(); ++i){
            path.append(letters.charAt(i));
            dfs(startIndex+1,digits,map,path);
            path.deleteCharAt(startIndex);
        }
    }
}
