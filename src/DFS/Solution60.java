package DFS;

/**
 * 60. 排列序列
 * @Author Hao Chen
 * @Create 2022/10/2 17:43
 */
public class Solution60 {
    private boolean[] used;
    private int[] factorial;
    private int n;
    private int k;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calFactorial(n);
        used = new boolean[n+1];
        StringBuilder path = new StringBuilder();
        dfs(0,path);
        return path.toString();
    }
    private void dfs(int index,StringBuilder path){ //index表示进入dfs之前已经选取了多少数字
        if(index == n){
            return;
        }
        int cnt = factorial[n-1-index]; //factorial[i]表示还有i个数字需要选择时，一共有多少种情况
        for(int i = 1; i <= n; ++i){
            if(used[i]) continue;
            if(cnt < k){
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index+1,path);
            return;
        }
    }
    private void calFactorial(int n ){
        factorial = new int[n+1];
        factorial[0] = 1;
        for(int i = 1; i <= n; ++i){
            factorial[i] = i * factorial[i-1];
        }
    }
}
