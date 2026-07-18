class Solution {
    public int countComponents(int n, int[][] edges) {
	int[] dsu = new int[n];
	for (int i=0; i<n; i++) dsu[i] = i;
	
	for (int[] edge: edges) {
		merge(dsu, edge[0], edge[1]);
	}

	Set<Integer> set = new HashSet<>();
	
	for (int p: dsu) set.add(getParent(dsu, p));

	return set.size();
	
}

int getParent(int[] dsu, int node) {
	if (dsu[node] == node) return node;
	
	dsu[node] = getParent(dsu, dsu[node]);
	return dsu[node];
}

void merge(int[] dsu, int n1, int n2) {
	int p1 = getParent(dsu, n1);
	int p2 = getParent(dsu, n2);
	
	dsu[p1] = p2;
}

}
