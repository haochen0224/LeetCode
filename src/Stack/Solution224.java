package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. 基本计算器
 * @Author Hao Chen
 * @Create 2022/10/4 20:22
 */
public class Solution224 {
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        nums.push(0);
        Deque<Character> ops = new ArrayDeque<>();
        s = s.replaceAll(" ","");
        char[] cs = s.toCharArray();
        for(int i = 0; i < s.length(); ++i){
            char ch = cs[i];
            if(ch == '('){
                ops.push(ch);
            }else if(ch == ')'){
                while(!ops.isEmpty()){
                    char c = ops.peek();
                    if(c != '('){
                        calcu(nums,ops);
                    }else{
                        ops.pop();
                        break;
                    }
                }
            }else{
                if(Character.isDigit(ch)){
                    int num = 0;
                    int j = i;
                    while(j < s.length() && Character.isDigit(cs[j])){
                        num = num * 10 + cs[j++] - '0';
                    }
                    nums.push(num);
                    i = j-1;
                }else{
                    if(i > 0 && (cs[i-1] == '(' || cs[i-1] == '+' || cs[i-1] == '-')){
                        nums.push(0);
                    }
                    while(!ops.isEmpty() && ops.peek() != '('){
                        calcu(nums,ops);
                    }
                    ops.push(ch);
                }
            }
        }
        while(!ops.isEmpty()){
            calcu(nums,ops);
        }
        return nums.pop();
    }
    private void calcu(Deque<Integer> nums,Deque<Character> ops){
        if(nums.size() < 2) return;
        if(ops.isEmpty()) return;
        int b = nums.pop(), a = nums.pop();
        char op = ops.pop();
        nums.push(op == '+' ? a+b : a-b);
    }
}
