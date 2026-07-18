class Solution {
    int[] parents;
    int n;
    public int countComponents(int n, int[][] edges) {
        this.n = n;
        parents = new int[n];

        for (int i=0; i<n; i++) {
            parents[i] = i;
        }

        for (int[] edge: edges) {
            union(edge[0], edge[1]);
        }

        int components = 0;
        for (int i=0; i<n; i++) {
            if (parents[i] == i) components++;
        }
        return components;
    }

    int find(int x) {
        if (parents[x] == x) return x;

        parents[x] = find(parents[x]);
        return parents[x];
    }

    void union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);

        parents[p1] = p2;
    }
}
