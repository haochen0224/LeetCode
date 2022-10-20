package Simulation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1700. 无法吃午餐的学生数量
 * @Author Hao Chen
 * @Create 2022/10/18 12:55
 */
public class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        if(students == null || students.length == 0){
            return 0;
        }
        Deque<Integer> stuStack = new ArrayDeque<>();
        Deque<Integer> sanStack = new ArrayDeque<>();
        int[] cnt = new int[2];
        for(int s : students){
            if(s == 0){
                ++cnt[0];
            }else{
                ++cnt[1];
            }
            stuStack.offerLast(s);
        }
        for(int s : sandwiches){
            sanStack.offerLast(s);
        }
        while(!sanStack.isEmpty()){
            if(stuStack.peekFirst() == sanStack.peekFirst()){
                if(stuStack.peekFirst() == 0){
                    --cnt[0];
                }else{
                    --cnt[1];
                }
                stuStack.pollFirst();
                sanStack.pollFirst();
            }else{
                if(cnt[0] == 0 || cnt[1] == 0){
                    return stuStack.size();
                }else{
                    stuStack.offerLast(stuStack.pollFirst());
                }
            }
        }
        return 0;
    }
}
