package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1106. 解析布尔表达式
 * @Author Hao Chen
 * @Create 2022/11/4 16:33
 */
public class Solution1106 {
    public boolean parseBoolExpr(String expression) {
        if(expression == null || expression.length() == 0){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < expression.length(); ++i){
            char ch = expression.charAt(i);
            if(ch == ','){
                continue;
            }else if(ch != ')'){
                stack.push(ch);
            }else{
                int t = 0, f = 0;
                while(stack.peek() != '('){
                    if(stack.peek() == 't'){
                        ++t;
                        stack.pop();
                    }else if(stack.peek() == 'f'){
                        ++f;
                        stack.pop();
                    }
                }
                stack.pop();
                char op = stack.pop();
                if(op == '!'){
                    stack.push(f == 1 ? 't' : 'f');
                }else if(op == '&'){
                    stack.push(f > 0 ? 'f' : 't');
                }else if(op == '|'){
                    stack.push(t > 0 ? 't' : 'f');
                }
            }
        }
        return stack.pop() == 't';
    }
}
