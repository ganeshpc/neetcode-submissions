class Solution {
    Set<Integer> visited = new HashSet<>();
    List<List<Integer>> graph = new ArrayList<>();
    public int countComponents(int n, int[][] edges) {

        for (int i=0; i<n; i++) graph.add(new ArrayList<>());

        for (var edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(i);
            }
        }

        return count;
    }

    void dfs(int node) {
        if (visited.contains(node)) return;

        visited.add(node);

        for (int nei: graph.get(node)) dfs(nei);
    }
}
