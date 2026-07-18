class Solution {
    int max = 1;
    class DSU {
        Map<Integer, Integer> parents = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();

        DSU(int[] arr) {
            for (int num: arr) {
                parents.put(num, num);
                size.put(num, 1);
            }
        }

        void union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) return;

            int s = size.get(p1) + size.get(p2);
            if (size.get(p1) < size.get(p2)) {
                parents.put(p1, p2);
                size.put(p2, s);
            } else {
                parents.put(p2, p1);
                size.put(p1, s);
            }

            max = Math.max(max, s);
        }

        int find(int node) {
            if (!parents.containsKey(node)) return -1;
            if (parents.get(node) == node) return node;

            int gp = find(parents.get(node));

            parents.put(node, gp);

            return gp;
        }
        
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        DSU dsu = new DSU(nums);

        for (int num: nums) {
            if (dsu.find(num-1) != -1) {
                dsu.union(num, num-1);
            }  

            if (dsu.find(num+1) != -1) {
                dsu.union(num, num+1);
            }  
        }
        return max;
    }
}
