package Greedy;

/**
 * 1055. 形成字符串的最短路径
 * @Author Hao Chen
 * @Create 2022/11/11 17:44
 */
public class Solution1055 {
    public int shortestWay(String source, String target) {
        if(source == null || target == null){
            return -1;
        }
        int n = target.length();
        int j = 0;
        int prev = j;
        int cnt = 0;
        while(j < n){
            prev = j;
            for(int i = 0; i < source.length() && j < n; ++i){
                if(source.charAt(i) == target.charAt(j)){
                    ++j;
                }
            }
            if(prev == j){ //source 中不存在 target.charAt(j)
                return -1;
            }
            ++cnt;
        }
        return cnt;
    }
}
