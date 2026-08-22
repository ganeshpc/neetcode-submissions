class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    public int countComponents(int n, int[][] edges) {
        for (int i=0; i<n; i++) graph.add(new ArrayList<>());

        for (var edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            count++;
            q.add(i);

            while (!q.isEmpty()) {
                int curr = q.remove();
                for (int nei: graph.get(curr)) {
                    if (!visited[nei]) {
                        q.add(nei);
                        visited[nei] = true;
                    }
                }
            }
        }

        return count;
    }
}
