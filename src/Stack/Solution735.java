package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 735. 行星碰撞
 * @Author Hao Chen
 * @Create 2022/9/21 17:50
 */
public class Solution735 {
    Deque<Integer> stack = new ArrayDeque<>();
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 0){
            return new int[0];
        }
        int index = 0;
        while(index < asteroids.length){
            int asteroid = asteroids[index];
            if(stack.isEmpty() || check(asteroid)){
                stack.push(asteroid);
                ++index;
                continue;
            }
            while(!stack.isEmpty() && !check(asteroid)){
                if(Math.abs(asteroid) > Math.abs(stack.peek())){
                    stack.pop();
                }else if(Math.abs(asteroid) == Math.abs(stack.peek())){
                    stack.pop();
                    ++index;
                    break;
                }else{
                    ++index;
                    break;
                }
            }
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            res[i++] = stack.pollLast();
        }
        return res;
    }
    private boolean check(int asteroid){
        if(asteroid > 0 && stack.peek() > 0) return true;
        if(asteroid < 0 && stack.peek() < 0) return true;
        if(asteroid > 0 && stack.peek() < 0) return true;
        return false;
    }
}
