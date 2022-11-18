package DP;

/**
 * 576. 出界的路径数
 * @Author Hao Chen
 * @Create 2022/11/17 18:27
 */
public class Solution576 {
    private final int MOD = (int)1e9+7;
    private int[] dx = {0,0,1,-1};
    private int[] dy = {1,-1,0,0};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        int[][][] dp = new int[maxMove+1][m][n];
        dp[0][startRow][startColumn] = 1;
        int res = 0;
        for(int i = 0; i < maxMove; ++i){
            for(int j = 0; j < m; ++j){
                for(int k = 0; k < n; ++k){
                    int cnt = dp[i][j][k];
                    if(cnt > 0){
                        for(int t = 0; t < 4; ++t){
                            int nj = j + dx[t];
                            int nk = k + dy[t];
                            if(nj >= 0 && nj < m && nk >= 0 && nk < n){
                                dp[i+1][nj][nk] = (dp[i+1][nj][nk] + cnt) % MOD;
                            }else{
                                res = (res + cnt) % MOD;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
