class Solution {
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

        for (int i=n-1; i>=idx; i--) {
            String sub = str.substring(idx, i+1);

            if (dict.contains(sub)) {
                if (dfs(i+1)) {
                    return true;
                }
            }
        }
        dp.put(idx, false); 
        return false;
    }
}
