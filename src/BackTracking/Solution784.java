package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * @Author Hao Chen
 * @Create 2022/10/29 19:15
 */
public class Solution784 {
    List<String> res;
    boolean[] visited;
    public List<String> letterCasePermutation(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        visited = new boolean[s.length()];
        char[] cs = s.toCharArray();
        dfs(cs,0);
        return res;
    }
    private void dfs(char[] cs,int index){
        if(index == cs.length){
            res.add(new String(cs));
            return;
        }

        if(Character.isDigit(cs[index])){
            dfs(cs,index+1);
        }else{
            cs[index] = Character.toUpperCase(cs[index]);
            dfs(cs,index+1);
            cs[index] = Character.toLowerCase(cs[index]);
            dfs(cs,index+1);
        }
    }
}
