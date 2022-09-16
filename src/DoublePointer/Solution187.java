package DoublePointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * @Author Hao Chen
 * @Create 2022/9/16 18:20
 */
public class Solution187 {
     public List<String> findRepeatedDnaSequences(String s) {
         if(s.length() == 0){
             return null;
         }
         List<String> res = new ArrayList<>();
         Map<String,Integer> map = new HashMap<>();
         for(int i = 0; i+10 <= s.length(); ++i){
             String cur = s.substring(i,i+10);
             int count = map.getOrDefault(cur,0);
             if(count == 1){
                 res.add(cur);
             }
             map.put(cur,count+1);
         }
         return res;
     }

     //更快的实现：字符串哈希
//    int N = (int)10e5+10, P = 131313;
//    public List<String> findRepeatedDnaSequences(String s) {
//        if(s.length() == 0){
//            return null;
//        }
//        int[] h = new int[N], p = new int[N];
//        p[0] = 1;
//        int n = s.length();
//        Map<Integer,Integer> map = new HashMap<>();
//        List<String> res = new ArrayList<>();
//        for(int i = 1; i <= n; ++i){
//            h[i] = h[i-1] * P + s.charAt(i-1);
//            p[i] = p[i-1] * P;
//        }
//        for(int i = 1; i+10-1 <= n; ++i){
//            int j = i+10-1;
//            int hash = h[j] - h[i-1]*p[j-i+1];
//            int count = map.getOrDefault(hash,0);
//            if(count == 1){
//                res.add(s.substring(i-1,j));
//            }
//            map.put(hash,count+1);
//        }
//        return res;
//    }
}
