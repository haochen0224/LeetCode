package COMPANY.ByteDance.Tree;

/**
 * 14. 最长公共前缀
 * @Author Hao Chen
 * @Create 2022/7/29 18:57
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String s : strs){
            trie.insert(s);
        }
        return trie.getLongestCommonPrefix(strs.length);
    }
}
class Trie{
    Trie[] children;
    boolean isEnd;
    int count;
    public Trie(){
        children = new Trie[26];
        isEnd = false;
        count = 0; //记录当前前缀树代表字符的出现次数
    }
    public void insert(String s){
        Trie cur = this;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(cur.children[ch-'a'] == null){
                cur.children[ch-'a'] = new Trie();
            }
            cur = cur.children[ch-'a'];
            cur.count++;
        }
        cur.isEnd = true;
    }
    public String getLongestCommonPrefix(int n){ //传入String数组长度
        StringBuffer res = new StringBuffer();
        Trie cur = this;
        while(cur != null){
            int pos = -1;
            for(int i = 0; i < 26; ++i){
                if(cur.children[i] != null && cur.children[i].count == n){ //当前前缀树代表字符的出现次数等于数组长度时，该字符才是公共字符
                    pos = i;
                    cur = cur.children[i];
                    break;
                }
            }
            if(pos == -1){
                return res.toString();
            }else{
                res.append((char)('a'+pos));
            }
        }
        return res.toString();
    }
}