package Simulation;

/**
 * 289. 生命游戏
 * @Author Hao Chen
 * @Create 2022/9/22 17:54
 */
public class Solution289 {
    int[] dx = {-1,0,1,0,1,1,-1,-1};
    int[] dy = {0,1,0,-1,-1,1,-1,1};
    boolean[][] modified;
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return;
        }
        m = board.length;
        n = board[0].length;
        modified = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int[][] clone = board.clone();
                if(clone[i][j] == 0){
                    if(canLive(clone,i,j)){
                        modified[i][j] = true;
                    }
                }else{
                    if(willDie(clone,i,j)){
                        modified[i][j] = true;
                    }
                }
            }
        }
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(modified[i][j]){
                    board[i][j] = board[i][j] == 0 ? 1 : 0;
                }
            }
        }
    }
    private boolean canLive(int[][] board,int x,int y){
        int live = 0;
        for(int i = 0; i < 8; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 1){
                ++live;
            }
        }
        return live == 3;
    }
    private boolean willDie(int[][] board,int x,int y){
        int live = 0;
        for(int i = 0; i < 8; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 1){
                ++live;
            }
        }
        return live < 2 || live > 3;
    }
}
