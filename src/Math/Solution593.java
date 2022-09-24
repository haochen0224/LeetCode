package Math;

import java.util.HashSet;
import java.util.Set;

/**
 * 593. 有效的正方形
 * @Author Hao Chen
 * @Create 2022/9/24 18:06
 */
public class Solution593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>(); //set存储各点之间距离的平方
        set.add(distance(p1,p2));
        set.add(distance(p1,p3));
        set.add(distance(p1,p4));
        set.add(distance(p2,p3));
        set.add(distance(p2,p4));
        set.add(distance(p3,p4));
        //如果是正方形，任意两点间的距离要么是边长，要么是对角线，且对角线长度是边长的根号2倍
        if(set.size() != 2 || set.contains(0)){
            return false;
        }
        Integer[] array = set.toArray(new Integer[2]);
        if(array[0] > array[1]){
            return array[0] == 2*array[1]; //set存储的各点之间距离的平方，对角线的平方是边长平方的2倍
        }else{
            return array[1] == 2*array[0];
        }
    }
    private int distance(int[] p1,int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
