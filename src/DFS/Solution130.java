package DFS;

/**
 * 130. 被围绕的区域
 * @Author Hao Chen
 * @Create 2022/8/17 18:33
 */
public class Solution130 {
    int m;
    int n;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for(int j = 0; j < n; ++j){
            dfs(board,0,j);
            dfs(board,m-1,j);
        }
        for(int i = 0; i < m; ++i){
            dfs(board,i,0);
            dfs(board,i,n-1);
        }
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board,int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O'){
            return;
        }
        board[x][y] = 'A';
        for(int i = 0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(board,nx,ny);
        }
    }
}
