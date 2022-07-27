package Other;

import java.util.*;

/**
 * 49. 字母异位词分组
 * @Author Hao Chen
 * @Create 2022/7/26 22:32
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //同一分组的字母异位词按字典序的排序是一致的，把这个作为key，把该key的字母异位词存到一个List中作为value
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
