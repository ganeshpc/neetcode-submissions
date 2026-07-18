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

        memo = new int[n1][n2];
        
        for (int[] arr: memo) Arrays.fill(arr, -1);

        return longest(0, 0);
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
