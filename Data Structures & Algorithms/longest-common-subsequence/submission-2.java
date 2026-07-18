class Solution {
    String str1;
    String str2;
    int n1;
    int n2;
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        str1 = text1;
        str2 = text2;

        n1 = str1.length();
        n2 = str2.length();

        memo = new int[n1+1][n2+1];

        for (int i=1; i<=n1; i++) {
            for (int j=1; j<=n2; j++) {
                char c1 = str1.charAt(i-1);
                char c2 = str2.charAt(j-1);

                if (c1 == c2) {
                    memo[i][j] = 1 + memo[i-1][j-1];
                } else {
                    memo[i][j] = Math.max(memo[i][j-1], memo[i-1][j]);
                }
            }
        }
        
        return memo[n1][n2];
        // return longest(0, 0);
    }

    int longest(int i1, int i2) {
        if (i1 == n1 || i2 == n2) return 0;

        if (memo[i1][i2] != -1) return memo[i1][i2];

        char c1 = str1.charAt(i1);
        char c2 = str2.charAt(i2);

        if (c1 == c2) return memo[i1][i2] = 1 + longest(i1+1, i2+1);

        int count1 = longest(i1+1, i2);
        int count2 = longest(i1, i2+1);

        return memo[i1][i2] = Math.max(count1, count2);
    }
}
