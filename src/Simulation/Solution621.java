package Simulation;

/**
 * 621. 任务调度器
 * @Author Hao Chen
 * @Create 2022/9/21 17:23
 */
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0){
            return 0;
        }
        int[] freq = new int[26];
        int maxTask = 0;
        for(char t : tasks){
            freq[t-'A']++;
            maxTask = Math.max(maxTask,freq[t-'A']);
        }
        int countMaxTask = 0;
        for(int i = 0; i < 26; ++i){
            if(freq[i] == maxTask){
                ++countMaxTask;
            }
        }
        return Math.max(tasks.length,(maxTask-1)*(n+1)+countMaxTask);
    }
}
