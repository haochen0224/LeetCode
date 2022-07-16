package Tree;

/**
 * 208. 实现 Trie (前缀树)
 * @Author Hao Chen
 * @Create 2022/7/15 18:51
 */
public class Solution208 {
}

class Trie {
    Trie[] children;
    boolean isEnd;
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert (String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(node.children[ch-'a'] == null){
                node.children[ch-'a'] = new Trie();
            }
            node = node.children[ch-'a'];
        }
        node.isEnd = true;
    }

    public Trie searchPrefix(String word){
        Trie node = this;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(node.children[ch-'a'] == null){
                return null;
            }
            node = node.children[ch-'a'];
        }
        return node;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }
}
