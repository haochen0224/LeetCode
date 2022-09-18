package Simulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 01.01. 判定字符是否唯一
 * @Author Hao Chen
 * @Create 2022/9/17 19:04
 */
public class Interview01_01 {
    public boolean isUnique(String astr) {
        if(astr.length() == 0){
            return true;
        }
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < astr.length(); ++i){
            if(set.contains(astr.charAt(i))){
                return false;
            }
            set.add(astr.charAt(i));
        }
        return true;
    }
}
