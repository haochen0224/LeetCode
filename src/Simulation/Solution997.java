package Simulation;

/**
 * 997. 找到小镇的法官
 * @Author Hao Chen
 * @Create 2022/9/24 14:02
 */
public class Solution997 {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        for(int i = 0; i < trust.length; ++i){
            int[] t = trust[i];
            ++outDegree[t[0]];
            ++inDegree[t[1]];
        }
        for(int i = 1; i <= n; ++i){
            if(outDegree[i] == 0 && inDegree[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}
