class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int count = n;

        for (int i=0; i<n; i++) dp[i][i] = true;

        for (int l=1; l<n; l++) {
           
            for (int i=0; i+l<n; i++) {
                if (s.charAt(i) == s.charAt(i+l)) {
                    if (i+1 > i+l-1)
                        dp[i][i+l] = true;    
                    else
                        dp[i][i+l] = dp[i+1][i+l-1];
                    if (dp[i][i+l]) count++;
                } 
            }
        }

        // for (var row: dp) {
        //     System.out.println(Arrays.toString(row));
        // }

        return count;
    }
}
