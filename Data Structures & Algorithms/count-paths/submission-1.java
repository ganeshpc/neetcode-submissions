class Solution {
    int m; 
    int n;
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        memo = new int[m][n];
        for (var arr: memo) Arrays.fill(arr, -1);
        return paths(1, 1); 
    }

    int paths(int x, int y) {
        if (x == m && y == n) return 1;
        if (x > m || y > n) return 0;
        if (memo[x-1][y-1] != -1) return memo[x-1][y-1];

        return memo[x-1][y-1] = paths(x+1, y) + paths(x, y+1);
    }
}
