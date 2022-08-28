package BackTracking;

/**
 * 79. 单词搜索
 * @Author Hao Chen
 * @Create 2022/8/27 18:54
 */
public class Solution79 {
    int m;
    int n;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null){
            return false;
        }
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(!visited[i][j]){
                    boolean found = dfs(board,i,j,word,0);
                    if(found){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,int x,int y,String word,int index){
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
                boolean found = dfs(board,nx,ny,word,index+1);
                if(found){
                    res = true;
                    break;
                }
            }
        }
        visited[x][y] = false;
        return res;
    }
}
