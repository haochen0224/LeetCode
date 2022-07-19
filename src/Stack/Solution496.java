package Stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * @Author Hao Chen
 * @Create 2022/7/18 21:55
 */
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums2.length; ++i){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                map.put(nums2[stack.pop()],nums2[i]);
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < res.length; ++i){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}
