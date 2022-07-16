package Tree;

/**
 * 720. 词典中最长的单词
 * @Author Hao Chen
 * @Create 2022/7/15 19:07
 */
public class Solution720 {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String str : words){
            trie.insert(str);
        }
        String longest = "";
        for(String str : words){
            if(trie.search(str)){
                if(str.length() > longest.length() || (str.length()==longest.length() && str.compareTo(longest) < 0)){
                    longest = str;
                }
            }
        }
        return longest;
    }
    class Trie{
        Trie[] children;
        boolean isEnd;
        public Trie(){
            children = new Trie[26];
            isEnd = false;
        }
        public void insert(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); ++i){
                char ch  = word.charAt(i);
                if(node.children[ch-'a'] == null){
                    node.children[ch-'a'] = new Trie();
                }
                node = node.children[ch-'a'];
            }
            node.isEnd = true;
        }
        public boolean search(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); ++i){
                char ch = word.charAt(i);
                if(node.children[ch-'a'] == null || !node.children[ch-'a'].isEnd){
                    return false;
                }
                node = node.children[ch-'a'];
            }
            return true;
        }
    }
}

