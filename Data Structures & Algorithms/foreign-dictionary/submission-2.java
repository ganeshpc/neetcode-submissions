class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;

        Map<Character, Set<Character>> graph = new HashMap<>();


        for (String word: words) {
            for (char c: word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i=1; i<n; i++) {
            int len = Math.min(words[i-1].length(), words[i].length());
            
            if (words[i-1].length() > words[i].length() && 
                words[i-1].substring(0, len).equals(words[i].substring(0, len))) {
                return "";
            }


            for (int j=0; j<len; j++) {
                char c1 = words[i-1].charAt(j);
                char c2 = words[i].charAt(j);
                if (c1 != c2) {
                    
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }

        System.out.println(graph);

        Stack<Character> sorted = new Stack<>();
        Set<Character> visited = new HashSet<>();

        for (char c: graph.keySet()) {
            if (!dfs(c, graph, visited, new HashSet<>(), sorted)) return "";
        }

        StringBuilder sb = new StringBuilder();

        while (!sorted.isEmpty()) {
            sb.append(sorted.pop());
        }

        return sb.toString();
    }

    boolean dfs(Character curr, Map<Character, Set<Character>> graph, Set<Character> visited, 
                                                Set<Character> inPath, Stack<Character> sorted) {
        if (inPath.contains(curr)) return false;
        if (visited.contains(curr)) return true;

        visited.add(curr);
        inPath.add(curr);

        for (char nei: graph.get(curr)) {
            if (!dfs(nei, graph, visited, inPath, sorted)) return false;
        }
        sorted.push(curr);
        return true;
    }
}
