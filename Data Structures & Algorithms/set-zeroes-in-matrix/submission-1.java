class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;

        int m = matrix.length;
        int n = matrix[0].length;

        firstRowZero = Arrays.stream(matrix[0]).anyMatch(num -> num == 0);

        for (int i=0; i<m; i++) {
                boolean rowZero = Arrays.stream(matrix[i]).anyMatch(num -> num == 0); 
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) matrix[0][j] = -1;
            }
            if (rowZero && i != 0) Arrays.fill(matrix[i], 0);
        }

        for (int i=0; i<n; i++) {
            if (matrix[0][i] == -1) {
                for (int j=0; j<m; j++) matrix[j][i] = 0;
            }
        }

        if (firstRowZero) Arrays.fill(matrix[0], 0);


    }
}
