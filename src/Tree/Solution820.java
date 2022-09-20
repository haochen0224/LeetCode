package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 820. 单词的压缩编码
 * @Author Hao Chen
 * @Create 2022/9/19 18:56
 */
public class Solution820 {
    public int minimumLengthEncoding(String[] words) {
        if(words.length == 0){
            return 0;
        }
        Map<Trie,Integer> map = new HashMap<>();
        Trie trie = new Trie();
        for(int i = 0; i < words.length; ++i){
            String s = words[i];
            Trie cur = trie;
            for(int j = s.length()-1; j >= 0; --j){
                cur = cur.get(s.charAt(j));
            }
            map.put(cur,i);
        }
        int res = 0;
        for(Trie node : map.keySet()){
            if(node.isEnd){
                res += words[map.get(node)].length()+1;
            }
        }
        return res;
    }
    static class Trie{
        Trie[] children;
        boolean isEnd;
        public Trie(){
            children = new Trie[26];
            isEnd = true;
        }
        public Trie get(char ch){
            if(children[ch-'a'] == null){
                children[ch-'a'] = new Trie();
                isEnd = false;
            }
            return children[ch-'a'];
        }
    }
}
