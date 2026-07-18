class Solution {
    Set<Integer> visited = new HashSet<>();
    List<List<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] pres) {
        graph = new ArrayList<>();

        for (int i=0; i<numCourses; i++) graph.add(new ArrayList<>());

        for (int[] edge: pres) graph.get(edge[0]).add(edge[1]);

            Set<Integer> inPath = new HashSet<>();
        for (int i=0; i<numCourses; i++) {
            inPath.clear();
            if (isCycle(i, inPath)) {
                return false;
            } 
        }
        return true;
    }

    boolean isCycle(int node, Set<Integer> inPath) {
        if (inPath.contains(node)) return true;
        if (visited.contains(node)) return false;

        inPath.add(node);
        visited.add(node);

        for (int nei: graph.get(node)) {
            if (isCycle(nei, inPath)) return true;
        }

        inPath.remove(node);
        return false;
    }
}
