class Solution {

    class DSU {
        int[] parents;
        DSU(int size) {
            parents = new int[size];
            for (int i=0; i<size; i++) parents[i] = i;
        }

        int find(int node) {
            if (parents[node] == node) return node;
            return parents[node] = find(parents[node]);
        }

        void union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            parents[p1] = p2;
        }
    }
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for (var edge: edges) dsu.union(edge[0], edge[1]);

        Set<Integer> hs = new HashSet<>();
        for (int i=0; i <n; i++) hs.add(dsu.find(i));

        return hs.size();
    }
}
