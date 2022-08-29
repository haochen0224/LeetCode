package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. 解数独
 * @Author Hao Chen
 * @Create 2022/8/28 23:13
 */
public class Solution37 {
    boolean[][] line = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][][] block = new boolean[3][3][9];
    List<int[]> spaces = new ArrayList<>();
    boolean valid = false;
    public void solveSudoku(char[][] board) {
        if(board == null){
            return;
        }
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == '.'){
                    spaces.add(new int[]{i,j});
                }else{
                    int num = board[i][j] - '0' - 1;
                    line[i][num] = column[j][num] = block[i/3][j/3][num] = true;
                }
            }
        }
        dfs(board,0);
    }
    private void dfs(char[][] board,int pos){
        if(pos == spaces.size()){
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for(int digit = 0; digit < 9 && !valid; ++digit){
            if(!line[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]){
                board[i][j] = (char)(digit+'0'+1);
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                dfs(board,pos+1);
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = false;
            }
        }
    }
}
