package Greedy;

import java.util.PriorityQueue;

/**
 * 767. 重构字符串
 * @Author Hao Chen
 * @Create 2022/8/26 17:24
 */
public class Solution767 {
    public String reorganizeString(String s) {
        if(s.length() < 2){
            return s;
        }
        int[] count = new int[26];
        int maxCount = 0;
        for(char ch : s.toCharArray()){
            count[ch-'a']++;
            maxCount = Math.max(maxCount,count[ch-'a']);
        }
        if(maxCount > (s.length()+1)/2){
            return "";
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b-'a']-count[a-'a']);
        for(char i = 'a'; i <= 'z'; ++i){
            if(count[i-'a'] != 0){
                pq.offer(i);
            }
        }
        StringBuffer res = new StringBuffer();
        while(pq.size() > 1){
            char ch1 = pq.poll();
            char ch2 = pq.poll();
            res.append(ch1);
            res.append(ch2);
            count[ch1-'a']--;
            count[ch2-'a']--;
            if(count[ch1-'a'] > 0){
                pq.offer(ch1);
            }
            if(count[ch2-'a'] > 0){
                pq.offer(ch2);
            }
        }
        if(!pq.isEmpty()){
            res.append(pq.poll());
        }
        return res.toString();
    }
}
