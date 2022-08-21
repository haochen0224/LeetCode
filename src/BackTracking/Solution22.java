package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * @Author Hao Chen
 * @Create 2022/8/21 16:58
 */
public class Solution22 {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs("",0,0,n);
        return res;
    }
    private void dfs(String curStr,int left,int right,int n){
        if(left == n && right == n){
            res.add(curStr);
            return;
        }
        if(left < right){
            return;
        }
        if(left < n){
            dfs(curStr+"(",left+1,right,n);
        }
        if(right < n){
            dfs(curStr+")",left,right+1,n);
        }
    }
}
