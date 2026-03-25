package hot100.map.a4;

/**
 * @author mlei@xjtu
 * @description Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * @create 2026/3/23 23:00
 */
public class Trie {
    //字典树
    private final Trie[] children;
    boolean isEnd;

    public Trie() {
        isEnd=false;
        this.children = new Trie[26];
    }

    public void insert(String word) {
        Trie trie=this;
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            if(trie.children[c-'a']==null){
                trie.children[c-'a']=new Trie();
            }
            trie=trie.children[c-'a'];
        }
        trie.isEnd=true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node!=null&&node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }

    private Trie searchPrefix(String prefix){
        Trie trie=this;
        for (int i = 0; i < prefix.length(); i++) {
            char c=prefix.charAt(i);
            if(trie.children[c-'a']==null){
                return null;
            }
            trie=trie.children[c-'a'];
        }
        return trie;
    }
}
