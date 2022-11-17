package DP;

/**
 * 361. 轰炸敌人
 * @Author Hao Chen
 * @Create 2022/11/16 19:17
 */
public class Solution361 {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] row = new int[m][n];
        int[][] col = new int[m][n];
        for(int i = 0; i < m; ++i){
            int left = 0;
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 'E'){
                    ++left;
                }else if(grid[i][j] == 'W'){
                    left = 0;
                }else{
                    row[i][j] = left;
                }
            }
            int right = 0;
            for(int j = n-1; j >= 0; --j){
                if(grid[i][j] == 'E'){
                    ++right;
                }else if(grid[i][j] == 'W'){
                    right = 0;
                }else{
                    row[i][j] += right;
                }
            }
        }
        for(int j = 0; j < n; ++j){
            int up = 0;
            for(int i = 0; i < m; ++i){
                if(grid[i][j] == 'E'){
                    ++up;
                }else if(grid[i][j] == 'W'){
                    up = 0;
                }else{
                    col[i][j] = up;
                }
            }
            int down = 0;
            for(int i = m-1; i >= 0; --i){
                if(grid[i][j] == 'E'){
                    ++down;
                }else if(grid[i][j] == 'W'){
                    down = 0;
                }else{
                    col[i][j] += down;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == '0'){
                    res = Math.max(res,row[i][j]+col[i][j]);
                }
            }
        }
        return res;
    }
//    int m;
//    int n;
//    public int maxKilledEnemies(char[][] grid) {
//        if(grid == null || grid.length == 0 || grid[0].length == 0){
//            return 0;
//        }
//        m = grid.length;
//        n = grid[0].length;
//        int res = 0;
//        for(int i = 0; i < m; ++i){
//            for(int j = 0; j < n; ++j){
//                if(grid[i][j] == '0'){
//                    res = Math.max(res,dfs(grid,i,j));
//                }
//            }
//        }
//        return res;
//    }
//    private int dfs(char[][] grid,int x,int y){
//        int curRes = 0;
//        for(int j = y-1; j >= 0 && grid[x][j] != 'W'; --j){
//            if(grid[x][j] == 'E') ++curRes;
//        }
//        for(int j = y+1; j < n && grid[x][j] != 'W'; ++j){
//            if(grid[x][j] == 'E') ++curRes;
//        }
//        for(int i = x-1; i >= 0 && grid[i][y] != 'W'; --i){
//            if(grid[i][y] == 'E') ++curRes;
//        }
//        for(int i = x+1; i < m && grid[i][y] != 'W'; ++i){
//            if(grid[i][y] == 'E') ++curRes;
//        }
//        return curRes;
//    }
}
