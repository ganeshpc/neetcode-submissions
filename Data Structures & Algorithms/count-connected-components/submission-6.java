class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;

    class DSU {
        int[] parent;
        public DSU(int n) {
            parent = new int[n];

            for (int i=0; i<n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] == x) return x;
            parent[x] = find(parent[x]);

            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return false;

            parent[px] = py;
            return true;
        }

        int uniques() {
            Set<Integer> hs = new HashSet<>();

            for (int p: parent) hs.add(find(p));
            return hs.size();
        }
    }

    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int res = n;

        for (var edge: edges) {
            if (dsu.union(edge[0], edge[1])) res--;
        }

        return res;
    }

    void dfs(int curr) {
        if (visited[curr]) return;

        visited[curr] = true;

        for (int nei: graph.get(curr)) {
            dfs(nei);
        }
    }
}
