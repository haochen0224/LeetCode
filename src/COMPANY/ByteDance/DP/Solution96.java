package COMPANY.ByteDance.DP;

/**
 * 96. 不同的二叉搜索树
 * @Author Hao Chen
 * @Create 2022/8/4 19:00
 */
public class Solution96 {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                G[i] += G[j-1] * G [i-j];
            }
        }
        return G[n];
    }
}
