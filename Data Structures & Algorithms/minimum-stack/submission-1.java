class MinStack {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {

    }
    
    public void push(int val) {
        st.push(val);

        if (min.isEmpty() || min.peek() >= val) 
            min.push(val);
    }
    
    public void pop() {
        int val = st.pop(); 
        int val1 = min.peek();
        if (val1 == val) {
            System.out.println("poped: " + min.peek());   
            min.pop();
        }  

    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/*
stack operations
at any point the the smallest should be maintained.

Raw: Along with the stack maintain a list and get max from list: O (n) for each operation
Sorted list like priority queue: remove ooperation will not work

use two stacks one stack will maintain actual elements and if if a smaller elemnt

 Actual:  5  

Minstakc: 5  
*/