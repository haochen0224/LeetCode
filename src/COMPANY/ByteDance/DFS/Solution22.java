package COMPANY.ByteDance.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * @Author Hao Chen
 * @Create 2022/7/28 14:01
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("",0,0,res,n);
        return res;
    }
    private void dfs(String curString,int left,int right,List<String> res,int n){
        if(left == n && right ==n){
            res.add(curString);
        }
        if(left < right){
            return;
        }
        if(left < n){
            dfs(curString+"(",left+1,right,res,n);
        }
        if(right < n){
            dfs(curString+")",left,right+1,res,n);
        }
    }
}
