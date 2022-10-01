package BackTracking;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 * @Author Hao Chen
 * @Create 2022/9/30 20:27
 */
public class Solution473 {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = 0;
        for(int m : matchsticks){
            totalLen += m;
        }
        if(totalLen % 4 != 0){
            return false;
        }
        Arrays.sort(matchsticks);
        int n = matchsticks.length;
        for(int i = 0,j = n-1; i < j; ++i,--j){
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] edges = new int[4];
        return dfs(0,matchsticks,edges,totalLen/4);
    }
    private boolean dfs(int index,int[] matchsticks,int[] edges,int len){
        if(index == matchsticks.length){
            return true;
        }
        for(int i = 0; i < edges.length; ++i){
            edges[i] += matchsticks[index];
            if(edges[i] <= len && dfs(index+1,matchsticks,edges,len)){
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
