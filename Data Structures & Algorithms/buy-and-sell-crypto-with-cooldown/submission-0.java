class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] profits = new int[n];

        for (int i=1; i<n; i++) {
            int prof = profits[i-1];
            for (int j=i-1; j>=0; j--) {
                int diff = prices[i] - prices[j];

                prof = Math.max(prof, diff+(j-2 < 0 ? 0 : profits[j-2]));
            }
            profits[i] = prof;
        }

        return profits[n-1];
    }
}

/*

*/