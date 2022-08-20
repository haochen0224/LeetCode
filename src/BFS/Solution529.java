package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 529. 扫雷游戏
 * @Author Hao Chen
 * @Create 2022/8/20 18:24
 */
public class Solution529 {
    int[] dx = {-1,0,1,0,-1,-1,1,1};
    int[] dy = {0,1,0,-1,-1,1,-1,1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0], j = click[1];
        if(board[i][j] == 'M'){
            board[i][j] = 'X';
        }else{
            bfs(board,i,j);
        }
        return board;
    }
    private void bfs(char[][] board,int i,int j){
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = 0;
            for(int k = 0; k < 8; ++k){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if(board[nx][ny] == 'M'){
                        ++count;
                    }
                }
            }
            if(count > 0){
                board[x][y] = (char)(count+'0');
            }else{
                board[x][y] = 'B';
                for(int k = 0; k < 8; ++k){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
