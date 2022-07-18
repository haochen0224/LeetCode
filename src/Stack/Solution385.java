package Stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 385. 迷你语法分析器
 * @Author Hao Chen
 * @Create 2022/7/17 22:16
 */
public class Solution385 {
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '['){
            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> stack = new LinkedList<>();
        boolean negative = false;
        int num = 0;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '-'){
                negative = true;
            }
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }else if(ch == '['){
                stack.push(new NestedInteger());
            }else if(ch == ',' || ch == ']'){
                if(Character.isDigit(s.charAt(i-1))){
                    if(negative){
                        num *= -1;
                    }
                    stack.peek().add(new NestedInteger(num));
                    num = 0;
                    negative = false;
                }
                if(ch == ']' && stack.size() > 1){
                    NestedInteger ni = stack.pop();
                    stack.peek().add(ni);
                }
            }
        }
        return stack.pop();
    }
}

class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger(){}

    // Constructor initializes a single integer.
    public NestedInteger(int value){}

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){return true;}

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){return  1;}

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){};

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){};

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){return  new ArrayList<NestedInteger>();}
    }

