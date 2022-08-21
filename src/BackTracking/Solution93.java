package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * @Author Hao Chen
 * @Create 2022/8/21 17:08
 */
public class Solution93 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() == 0){
            return res;
        }
        LinkedList<String> path = new LinkedList<>();
        dfs(0,s,path);
        return res;
    }
    private void dfs(int startIndex,String s,LinkedList<String> path){
        if(path.size() > 4){
            return;
        }
        if(startIndex == s.length() && path.size() == 4){
            res.add(toResult(path));
        }
        for(int i = startIndex; i < s.length(); ++i){
            String subStr = s.substring(startIndex,i+1);
            if(!isValid(subStr)){
                continue;
            }
            path.addLast(subStr);
            dfs(i+1,s,path);
            path.removeLast();
        }
    }
    private boolean isValid(String s){
        if(s.length() > 3) return false;
        if(s.charAt(0) == '0' && s.length() > 1) return false;
        if(Integer.valueOf(s) < 0 || Integer.valueOf(s) > 255) return false;
        return true;
    }
    private String toResult(LinkedList<String> path){
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < path.size(); ++i){
            res.append(path.get(i));
            if(i != path.size()-1){
                res.append(".");
            }
        }
        return res.toString();
    }
}
