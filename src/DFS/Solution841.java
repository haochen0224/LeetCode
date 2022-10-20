package DFS;

import java.util.List;

/**
 * 841. 钥匙和房间
 * @Author Hao Chen
 * @Create 2022/10/19 23:56
 */
public class Solution841 {
    boolean[] visited;
    int num;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null){
            return true;
        }
        int n = rooms.size();
        visited = new boolean[n];
        dfs(rooms,0);
        return num == n;
    }
    private void dfs(List<List<Integer>> rooms,int index){
        ++num;
        visited[index] = true;
        List<Integer> cur = rooms.get(index);
        for(int next : cur){
            if(!visited[next]){
                dfs(rooms,next);
            }
        }
    }
}
