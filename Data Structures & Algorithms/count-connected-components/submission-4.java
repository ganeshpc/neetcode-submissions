class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        for (int i=0; i<n; i++) graph.add(new ArrayList<>());

        for (var edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];
        int count = 0;

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                count++;

                dfs(i);
            }
        }

        return count;
    }

    void dfs(int curr) {
        if (visited[curr]) return;

        visited[curr] = true;

        for (int nei: graph.get(curr)) {
            dfs(nei);
        }
    }
}
