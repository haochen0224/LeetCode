package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * @Author Hao Chen
 * @Create 2022/8/28 18:44
 */
public class Solution842 {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        if(num == null){
            return res;
        }
        dfs(num.toCharArray(),res,0);
        return res;
    }
    private boolean dfs(char[] digits,List<Integer> res,int startIndex){
        if(startIndex == digits.length && res.size() >= 3){
            return true;
        }
        int size = res.size();
        for(int i = startIndex; i < digits.length; ++i){
            if(i > startIndex && digits[startIndex] == '0'){
                continue;
            }
            long num = getNum(digits,startIndex,i);
            if(num > Integer.MAX_VALUE){
                break;
            }
            if(size >= 2 && num > res.get(size-1)+res.get(size-2)){
                break;
            }
            if(size <= 1 || num == res.get(size-1)+res.get(size-2)){
                res.add((int)num);
                if(dfs(digits,res,i+1)){
                    return true;
                }else{
                    res.remove(res.size()-1);
                }
            }
        }
        return false;
    }
    private long getNum(char[] digits,int start,int end){
        long res = 0;
        for(int i = start; i <= end; ++i){
            res = res*10 + digits[i] - '0';
        }
        return res;
    }
}
