class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length; 
        if (n == 0) return 0;
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<n; i++) {
            String op = tokens[i];
            int res;
            if (op.equals("+")) {
                int num1 = st.pop();
                int num2 = st.pop();
                res = num1 + num2;
                st.push(res);
            } else if (op.equals("-")) {
                int num2 = st.pop();
                int num1 = st.pop();
                res = num1 - num2;
                st.push(res);
            } else if (op.equals("*")) {
                int num2 = st.pop();
                int num1 = st.pop();
                res = num1 * num2;
                st.push(res);
            } else if (op.equals("/")) {
                int num1 = st.pop();
                int num2 = st.pop();
                double val = num2 / num1;
                res = (int)Math.floor(val);
                st.push(res);
            } else {
                int num = Integer.valueOf(op);
                st.push(num);
            }
        }
        
        return st.peek();
    }
}
