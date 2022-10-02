package DoublePointer;

/**
 * 777. 在LR字符串中交换相邻字符
 * @Author Hao Chen
 * @Create 2022/10/1 21:03
 */
public class Solution777 {
    public boolean canTransform(String start, String end) {
        if(start.length() != end.length()){
            return false;
        }
        int n = start.length();
        int i = 0, j = 0;
        while(i < n && j < n){
            while(i < n && start.charAt(i) == 'X') ++i;
            while(j < n && end.charAt(j) == 'X') ++j;
            if(i < n && j < n){
                if(start.charAt(i) != end.charAt(j)) return false;
                if((start.charAt(i) == 'L' && i < j) || (start.charAt(i) == 'R' && i > j)) return false;
                ++i;
                ++j;
            }
        }
        while(i < n){
            if(start.charAt(i++) != 'X') return false;
        }
        while(j < n){
            if(end.charAt(j++) != 'X') return false;
        }
        return true;
    }
}
