class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (st.isEmpty()) return false;
                char top = st.peek();
                if ((top == '(' && c == ')') || (top == '[' && c == ']') || (top == '{' && c == '}')) {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(c);
            }
        }

        if (st.isEmpty()) return true;

        return false;
    }
}
