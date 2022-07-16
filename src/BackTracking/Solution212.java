package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 * @Author Hao Chen
 * @Create 2022/7/15 23:13
 */
public class Solution212 {
    Trie trie = new Trie();
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int m;
    int n;
    boolean[][] visited;
    Set<String> set;
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        set = new HashSet<>();
        for(String word :words){
            trie.insert(word);
        }
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(!visited[i][j]){
                    int cur = board[i][j] - 'a';
                    if(trie.children[cur] != null){
                        visited[i][j] = true;
                        dfs(i,j,trie.children[cur]);
                        visited[i][j] = false;
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        for(String str : set){
            res.add(str);
        }
        return res;
    }
    private void dfs(int x, int y, Trie curTrie){
        if(curTrie.s != null){
            set.add(curTrie.s);
        }
        for(int i = 0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]){
                continue;
            }
            int next = board[nx][ny] - 'a';
            if(curTrie.children[next] != null){
                visited[nx][ny] = true;
                dfs(nx,ny,curTrie.children[next]);
                visited[nx][ny] = false;
            }
        }
    }
}
class Trie{
    Trie[] children;
    String s;
    public Trie(){
        children = new Trie[26];
    }
    public void insert(String str){
        Trie node = this;
        for(int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            if(node.children[ch-'a'] == null){
                node.children[ch-'a'] = new Trie();
            }
            node = node.children[ch-'a'];
        }
        node.s = str;
    }
}
