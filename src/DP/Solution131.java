package DP;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * @Author Hao Chen
 * @Create 2022/8/16 17:49
 */
public class Solution131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        boolean[][] dp = new boolean[len][len];
        for(int right = 0; right < len; ++right){
            for(int left = 0; left <= right; ++left){
                if(s.charAt(left)==s.charAt(right) && (right-left+1<3 || dp[left+1][right-1])){
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new LinkedList<>();
        dfs(s,0,dp,stack,res);
        return res;
    }
    private void dfs(String s,int start,boolean[][] dp,Deque<String> stack,List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<String>(stack));
        }
        for(int i = start; i < s.length(); ++i){
            if(dp[start][i]){
                stack.addLast(s.substring(start,i+1));
                dfs(s,i+1,dp,stack,res);
                stack.removeLast();
            }
        }
    }
}
