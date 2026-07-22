class Solution {

    class DSU {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();

        DSU(Set<Integer> nums) {
            for (var num: nums) {
                parent.put(num, num);
                size.put(num, 1);
            }
        }

        int find(int x) {
            if (parent.get(x) == x) return x;
            int p = find(parent.get(x));
            parent.put(x, p); 
            return p;
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            int sx = size.get(px); 
            int sy = size.get(py); 
            if (px < py) {
                parent.put(px, py);
                size.put(py, sx+sy);
            } else {
                parent.put(py, px);
                size.put(px, sx+sy);
            }
        }

        int getMax() {
            return size.values().stream().max(Integer::compare).orElse(0);
        }
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> hs =  Arrays.stream(nums).boxed().collect(Collectors.toSet());

        DSU dsu = new DSU(hs);

        for (int num: hs) {
            if (hs.contains(num-1)) {
                dsu.union(num, num-1);
            }
            if (hs.contains(num+1)) {
                dsu.union(num, num+1);
            }
        }

        return dsu.getMax();
    }
}
