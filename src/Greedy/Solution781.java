package Greedy;

import java.util.Arrays;

/**
 * 781. 森林中的兔子
 * @Author Hao Chen
 * @Create 2022/10/6 18:51
 */
public class Solution781 {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int n = answers.length;
        int res = 0;
        for(int i = 0; i < n; ++i){
            int cnt = answers[i];
            res += cnt + 1;
            while(cnt-- > 0 && i+1 < n && answers[i] == answers[i+1]) ++i;
        }
        return res;
    }
}
