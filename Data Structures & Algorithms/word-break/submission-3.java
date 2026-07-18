class Solution {

    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }

    class Trie {
        TrieNode root = new TrieNode();

        void add(String str) {
            int n = str.length();
            TrieNode temp = root;
            for (int i=0; i<n; i++) {
                char c = str.charAt(i);

                if (temp.children[c] == null) temp.children[c] = new TrieNode();

                temp = temp.children[c];
            }

            temp.isEnd = true;
        }

    }

    Set<String> dict = new HashSet<>();
    int n;
    String str;
    Map<Integer, Boolean> dp = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        str = s;
        n = str.length(); 

        for (String word: wordDict) dict.add(word);

        return dfs(0);
    }

    boolean dfs(int idx) {
        if (idx == n) return true;

        if (dp.containsKey(idx)) return dp.get(idx);

        for (String word: dict) {
            if (idx+word.length() <= n && str.substring(idx, idx+word.length()).equals(word)) {
                if (dfs(idx+word.length())) {
                    return true;
                }
            }
        }

        // for (int i=n-1; i>=idx; i--) {
        //     String sub = str.substring(idx, i+1);

        //     if (dict.contains(sub)) {
        //         if (dfs(i+1)) {
        //             return true;
        //         }
        //     }
        // }
        dp.put(idx, false); 
        return false;
    }
}
