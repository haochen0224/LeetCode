package DoublePointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * @Author Hao Chen
 * @Create 2022/9/23 22:23
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(Character ch : p.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        int left = 0, right = 0, valid = p.length();
        while(right < s.length()){
            if(need.containsKey(s.charAt(right))){
                window.put(s.charAt(right),window.getOrDefault(s.charAt(right),0)+1);
                if(window.get(s.charAt(right)) <= need.get(s.charAt(right))){
                    --valid;
                }
            }
            while(valid == 0){
                if(right-left+1 == p.length()) res.add(left);
                if(need.containsKey(s.charAt(left))){
                    window.put(s.charAt(left),window.get(s.charAt(left))-1);
                    if(window.get(s.charAt(left)) < need.get(s.charAt(left))){
                        ++valid;
                    }
                }
                ++left;
            }
            ++right;
        }
        return res;
    }
}
