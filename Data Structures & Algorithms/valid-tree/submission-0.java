class Solution {
    public boolean validTree(int n, int[][] edges) {
        int edgeCount = edges.length;
        if (n-1 != edgeCount) return false;

        List<List<Integer>> graph = createGraph(edges, n);

        boolean[] visited = new boolean[n];
        return dfs(graph, 0, visited, 0);
    }

    boolean dfs(List<List<Integer>> graph, int curr, boolean[] visited, int prev) {

        if (visited[curr]) return false;
        visited[curr] = true;

        for (int nei: graph.get(curr)) {
            if (nei != prev) {
                if (!dfs(graph, nei, visited, curr)) return false;
            }
        }
        return true;
    }

    List<List<Integer>> createGraph(int[][] edges, int n) {
        List<List<Integer>> graph  = new ArrayList<>();       
        for (int i=0; i<n; i++) graph.add(new ArrayList<>());

        for (int[] edge: edges) {
            int src = edge[0];
            int dest = edge[1];

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        return graph;
    }
}
