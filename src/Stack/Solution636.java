package Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 636. 函数的独占时间
 * @Author Hao Chen
 * @Create 2022/7/18 18:24
 */
public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if(n == 0){
            return res;
        }

        Deque<Integer> stack = new LinkedList<>();
        String[] str = logs.get(0).split(":");
        int prev = Integer.parseInt(str[2]);
        stack.push(Integer.parseInt(str[0]));
        int i = 1;
        while(i < logs.size()){
            String[] record = logs.get(i).split(":");
            int curId = Integer.parseInt(record[0]);
            int curTime = Integer.parseInt(record[2]);
            if(record[1].equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()] += curTime - prev;
                }
                stack.push(curId);
                prev = curTime;
            }else if(record[1].equals("end")){
                res[stack.peek()] += curTime - prev + 1;
                stack.pop();
                prev = curTime + 1;
            }
            ++i;
        }
        return res;
    }
}
