class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int i = cell[0];
            int j = cell[1];
            
            if (i-1 >= 0 && grid[i-1][j] == Integer.MAX_VALUE) {
                grid[i-1][j] = grid[i][j]+1; 
                q.add(new int[]{i-1, j});
            }

            if (j-1 >= 0 && grid[i][j-1] == Integer.MAX_VALUE) {
                grid[i][j-1] = grid[i][j]+1; 
                q.add(new int[]{i, j-1});
            }

            if (i+1 < m && grid[i+1][j] == Integer.MAX_VALUE) {
                grid[i+1][j] = grid[i][j]+1; 
                q.add(new int[]{i+1, j});
            }

            if (j+1 < n && grid[i][j+1] == Integer.MAX_VALUE) {
                grid[i][j+1] = grid[i][j]+1; 
                q.add(new int[]{i, j+1});
            }
        }
        
    }
}
