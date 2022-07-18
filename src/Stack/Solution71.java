package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. 简化路径
 * @Author Hao Chen
 * @Create 2022/7/17 19:21
 */
public class Solution71 {
    public String simplifyPath(String path) {
        String[] strArray = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for(String name : strArray){
            if(name.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(name.length() > 0 && !name.equals(".")){
                stack.push(name);
            }
        }
        StringBuffer res = new StringBuffer();
        if(stack.isEmpty()){
            res.append("/");
        }
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
            res.insert(0,"/");
        }
        return res.toString();
    }
}
