package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Hao Chen
 * @Create 2022/11/15 19:43
 */
public class Solution254 {
    public List<List<Integer>> getFactors(int n) {
        if(n <= 1){
            return new ArrayList<>();
        }
        return dfs(n,2);
    }
    private List<List<Integer>> dfs(int n,int start){
        List<List<Integer>> res = new ArrayList<>();
        for(int i = start; i*i <= n; ++i){
            if(n % i == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(n/i);
                temp.add(i);
                res.add(temp);
                for(List<Integer> list : dfs(n/i,i)){
                    list.add(i);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
