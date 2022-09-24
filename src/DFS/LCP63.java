package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * LCP 63. 弹珠游戏
 * @Author Hao Chen
 * @Create 2022/9/24 13:45
 */
public class LCP63 {
    String[] plate;
    List<int[]> res;
    static final int DOWNWARDS = 0;
    static final int UPWARDS = 1;
    static final int TOLEFT = 2;
    static final int TORIGHT = 3;
    int m;
    int n;
    public int[][] ballGame(int num, String[] plate) {
        this.plate = plate;
        m = plate.length;
        n = plate[0].length();
        res = new ArrayList<>();
        for(int j = 1; j < n-1; ++j){
            if(plate[0].charAt(j) == 'O'){
                continue;
            }
            if(plate[0].charAt(j) == '.' && dfs(0,j,num,DOWNWARDS)){
                res.add(new int[]{0,j});
            }
        }
        for(int j = 1; j < n-1; ++j){
            if(plate[m-1].charAt(j) == 'O'){
                continue;
            }
            if(plate[m-1].charAt(j) == '.' && dfs(m-1,j,num,UPWARDS)){
                res.add(new int[]{m-1,j});
            }
        }
        for(int i = 1; i < m-1; ++i){
            if(plate[i].charAt(0) == 'O'){
                continue;
            }
            if(plate[i].charAt(0) == '.' && dfs(i,0,num,TORIGHT)){
                res.add(new int[]{i,0});
            }
        }
        for(int i = 1; i < m-1; ++i){
            if(plate[i].charAt(n-1) == 'O'){
                continue;
            }
            if(plate[i].charAt(n-1) == '.' && dfs(i,n-1,num,TOLEFT)){
                res.add(new int[]{i,n-1});
            }
        }
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < ans.length; ++i){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }
    private boolean dfs(int x,int y,int num,int direction){
        if(num < 0 || x < 0 || x >= m || y < 0 || y >= n){
            return false;
        }
        if(plate[x].charAt(y) == 'O'){
            return true;
        }
        if(plate[x].charAt(y) == '.'){
            if(direction == DOWNWARDS){
                return dfs(x+1,y,num-1,DOWNWARDS);
            }else if(direction == UPWARDS){
                return dfs(x-1,y,num-1,UPWARDS);
            }else if(direction == TOLEFT){
                return dfs(x,y-1,num-1,TOLEFT);
            }else if(direction == TORIGHT){
                return dfs(x,y+1,num-1,TORIGHT);
            }
        }else if(plate[x].charAt(y) == 'E'){
            if(direction == DOWNWARDS){
                return dfs(x,y-1,num-1,TOLEFT);
            }else if(direction == UPWARDS){
                return dfs(x,y+1,num-1,TORIGHT);
            }else if(direction == TOLEFT){
                return dfs(x-1,y,num-1,UPWARDS);
            }else if(direction == TORIGHT){
                return dfs(x+1,y,num-1,DOWNWARDS);
            }
        }else if(plate[x].charAt(y) == 'W'){
            if(direction == DOWNWARDS){
                return dfs(x,y+1,num-1,TORIGHT);
            }else if(direction == UPWARDS){
                return dfs(x,y-1,num-1,TOLEFT);
            }else if(direction == TOLEFT){
                return dfs(x+1,y,num-1,DOWNWARDS);
            }else if(direction == TORIGHT){
                return dfs(x-1,y,num-1,UPWARDS);
            }
        }
        return false;
    }
}
