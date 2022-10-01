package DoublePointer;

/**
 * 459. 重复的子字符串
 * @Author Hao Chen
 * @Create 2022/9/30 17:45
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null){
            return true;
        }
        int n = s.length();
        for(int i = 1; i <= n/2; ++i){
            if(n % i == 0){
                boolean match = true;
                for(int j = i; j < n; ++j){
                    if(s.charAt(j) != s.charAt(j-i)){
                        match = false;
                        break;
                    }
                }
                if(match){
                    return true;
                }
            }
        }
        return false;
    }
}
