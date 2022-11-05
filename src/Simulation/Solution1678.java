package Simulation;

/**
 * 1678. 设计 Goal 解析器
 * @Author Hao Chen
 * @Create 2022/11/5 18:22
 */
public class Solution1678 {
    public String interpret(String command) {
        if(command == null || command.length() == 0){
            return "";
        }
        int n = command.length();
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < n){
            if(command.charAt(i) == 'G'){
                res.append("G");
                ++i;
            }else if(command.charAt(i) == '('){
                if(command.charAt(i+1) == ')'){
                    res.append("o");
                    i += 2;
                }else{
                    res.append("al");
                    i += 4;
                }
            }
        }
        return res.toString();
    }
}
