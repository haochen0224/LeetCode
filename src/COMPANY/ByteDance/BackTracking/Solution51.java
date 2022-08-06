package COMPANY.ByteDance.BackTracking;

import java.util.*;

/**
 * 51. N 皇后
 * @Author Hao Chen
 * @Create 2022/8/5 18:17
 */
public class Solution51 {
    List<List<String>> solution;
    int[] queens;
    public List<List<String>> solveNQueens(int n) {
        solution = new ArrayList<>();
        queens = new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> column = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        dfs(0,n,column,diagonals1,diagonals2);
        return solution;
    }
    private void dfs(int row,int n,Set<Integer> column,Set<Integer> diagonals1,Set<Integer> diagonals2){
        if(row == n){
            List<String> board = generateBoard(queens,n);
            solution.add(board);
            return;
        }
        for(int i = 0; i < n; ++i){
            if(column.contains(i)){
                continue;
            }
            int diag1 = row - i;
            if(diagonals1.contains(diag1)){
                continue;
            }
            int diag2 = row + i;
            if(diagonals2.contains(diag2)){
                continue;
            }
            queens[row] = i;
            column.add(i);
            diagonals1.add(diag1);
            diagonals2.add(diag2);
            dfs(row+1,n,column,diagonals1,diagonals2);
            queens[row] = -1;
            column.remove(i);
            diagonals1.remove(diag1);
            diagonals2.remove(diag2);
        }
    }
    private List<String> generateBoard(int[] queens,int n){
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
