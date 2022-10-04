package Greedy;

/**
 * 921. 使括号有效的最少添加
 * @Author Hao Chen
 * @Create 2022/10/3 15:02
 */
public class Solution921 {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int leftCount = 0;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '('){
                ++leftCount;
            }else{
                if(leftCount > 0){
                    --leftCount;
                }else{
                    ++res;
                }
            }
        }
        return res + leftCount;
    }
}
