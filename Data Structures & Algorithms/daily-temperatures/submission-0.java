class Solution {
    public int[] dailyTemperatures(int[] ts) {
        int n = ts.length;

        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i=n-1; i>=0; i--) {
            int temp = ts[i]; 
            while (!st.isEmpty()) {
                if (ts[st.peek()] <= temp) st.pop();
                else break;
            }

            if (!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }

            st.push(i);
        }

        return ans;
    }
}
