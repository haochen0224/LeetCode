package COMPANY.ByteDance.DFS;

/**
 * 79. 单词搜索
 * @Author Hao Chen
 * @Create 2022/7/31 18:00
 */
public class Solution79 {
    int m;
    int n;
    char[][] board;
    boolean[][] visited;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                boolean found = dfs(i,j,word,0);
                if(found){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int x, int y, String word, int index){
        if(board[x][y] != word.charAt(index)){
            return false;
        }else if(index == word.length()-1){
            return true;
        }
        visited[x][y] = true;
        boolean res = false;
        for(int i = 0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                boolean flag = dfs(nx,ny,word,index+1);
                if(flag){
                    res = true;
                    break;
                }
            }
        }
        visited[x][y] = false;
        return res;
    }
}
