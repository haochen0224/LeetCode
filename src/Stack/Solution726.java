package Stack;

import java.util.*;

/**
 * 726. 原子的数量
 * @Author Hao Chen
 * @Create 2022/7/18 19:35
 */
public class Solution726 {
    int index;
    int n;
    String formula;
    public String countOfAtoms(String formula) {
        this.index = 0;
        this.n = formula.length();
        this.formula = formula;
        if(n == 0){
            return "";
        }
        Deque<Map<String,Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<String,Integer>());
        while(index < n){
            char ch = formula.charAt(index);
            if(ch == '('){
                stack.push(new HashMap<String,Integer>());
                ++index;
            }else if(ch == ')'){
                ++index;
                int num = parseNum();
                Map<String,Integer> popMap = stack.pop();
                Map<String,Integer> topMap = stack.peek();
                for(Map.Entry<String,Integer> entry : popMap.entrySet()){
                    String atom = entry.getKey();
                    int value = entry.getValue();
                    topMap.put(atom,topMap.getOrDefault(atom,0) + value*num);
                }
            }else{
                String atom = parseAtom();
                int num = parseNum();
                Map<String,Integer> topMap = stack.peek();
                topMap.put(atom,topMap.getOrDefault(atom,0)+num);
            }
        }
        Map<String,Integer> map = stack.pop();
        TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>(map);
        StringBuffer res = new StringBuffer();
        for(Map.Entry<String,Integer> entry : treeMap.entrySet()){
            String atom = entry.getKey();
            int num = entry.getValue();
            res.append(atom);
            if(num > 1){
                res.append(num);
            }
        }
        return res.toString();
    }
    private String parseAtom(){
        StringBuffer res = new StringBuffer();
        res.append(formula.charAt(index++));
        while(index < n && Character.isLowerCase(formula.charAt(index))){
            res.append(formula.charAt(index++));
        }
        return res.toString();
    }

    private int parseNum(){
        if(index == n || !Character.isDigit(formula.charAt(index))){
            return 1;
        }
        int num = 0;
        while(index < n && Character.isDigit(formula.charAt(index))){
            num = num * 10 + formula.charAt(index++) - '0';
        }
        return num;
    }
}
