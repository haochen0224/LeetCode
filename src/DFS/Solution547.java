package DFS;

/**
 * 547. 省份数量
 * @Author Hao Chen
 * @Create 2022/8/17 18:16
 */
public class Solution547 {
    int n;
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        visited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; ++i){
            if(!visited[i]){
                dfs(isConnected,i);
                ++res;
            }
        }
        return res;
    }
    private void dfs(int[][] isConnected,int i){
        visited[i] = true;
        for(int j = 0; j < n; ++j){
            if(!visited[j] && isConnected[i][j] == 1){
                dfs(isConnected,j);
            }
        }
    }
}
