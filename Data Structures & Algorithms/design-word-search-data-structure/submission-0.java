class WordDictionary {
    class Trie {
        TrieNode root = new TrieNode();

        void add(String word) {
            TrieNode temp = root;
            for (char c: word.toCharArray()) {
                temp.children.putIfAbsent(c, new TrieNode());
                temp = temp.children.get(c);
            }
            temp.isEnd = true;
        }

        boolean search(String word) {
            return recurse(word, 0, root);
        }

        boolean recurse(String word, int idx, TrieNode node) {
            int n = word.length();
            if (idx == n) {
                if (node.isEnd == true)
                    return true;
                else
                    return false;
            }
            char c = word.charAt(idx);

            if (c == '.') {
                for (Character child: node.children.keySet()) {
                    if (recurse(word, idx+1, node.children.get(child)))
                        return true;
                }
            } else {
                if (node.children.containsKey(c)) {
                    return recurse(word, idx+1, node.children.get(c));
                } else {
                    return false;
                }
            }
            return false;
        }
    }
    class TrieNode {
        boolean isEnd = false;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }
}
