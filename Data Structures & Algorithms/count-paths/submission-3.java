class Solution {
    int m; 
    int n;
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        memo = new int[m][n];
        // for (var arr: memo) Arrays.fill(arr, -1);

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {

                if (i == m-1 && j == n-1) memo[i][j] = 1;
                else if (i == m-1) memo[i][j] = memo[i][j+1];
                else if (j == n-1) memo[i][j] = memo[i+1][j];
                else memo[i][j] = memo[i+1][j] + memo[i][j+1];
            }
        }

        return memo[0][0];
    }

    int paths(int x, int y) {
        if (x == m && y == n) return 1;
        if (x > m || y > n) return 0;
        if (memo[x-1][y-1] != -1) return memo[x-1][y-1];

        return memo[x-1][y-1] = paths(x+1, y) + paths(x, y+1);
    }
}
