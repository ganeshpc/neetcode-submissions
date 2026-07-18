class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();   

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            for (int d=0; d<4; d++) {
                int newX = x + dx[d];
                int newY = y + dy[d];

                if (newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
                if (grid[newX][newY] == -1) continue;

                if (grid[newX][newY] != Integer.MAX_VALUE) continue;

                grid[newX][newY] = dist + 1;

                queue.add(new int[]{newX, newY, dist+1});
            }
        }


    }
}
