class Solution {
    char[][] board;
    String word;
    int m, n, len;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        len =  word.length();
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (found(i, j, 0, visited)) return true;
            }
        }

        return false;
    }

    boolean found(int i, int j, int ctr, boolean[][] visited) {
        if (ctr == len) return true;
        if (i < 0 || j < 0 || i == m || j == n) return false;
        if (visited[i][j]) return false;

        if (word.charAt(ctr) != board[i][j]) return false;

        visited[i][j] = true;

        if (found(i+1, j, ctr+1, visited)) return true;
        if (found(i-1, j, ctr+1, visited)) return true;
        if (found(i, j+1, ctr+1, visited)) return true;
        if (found(i, j-1, ctr+1, visited)) return true;

        visited[i][j] = false;
        return false;
    }


}
