package Simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.02. 单词频率
 * @Author Hao Chen
 * @Create 2022/10/19 21:16
 */
public class Interview16_02 {
    class WordsFrequency {
        Map<String,Integer> map;
        public WordsFrequency(String[] book) {
            map = new HashMap<>();
            for(String s : book){
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word,0);
        }
    }
}
