class MedianFinder {

    Queue<Integer> right = new PriorityQueue<>(); 
    Queue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); 
    int n = 0;

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        n++;

        right.offer(num);
        int minNum = right.poll();
        left.offer(minNum);

        if (left.size() > right.size() + 1) {
            right.offer(left.remove());
        } 

        // System.out.println(left + " " + right);
    }
    
    public double findMedian() {
        if (n%2 == 0) {
            // double 
            return (1d*left.peek()+right.peek()) / 2;
        }    
        return left.peek();
    }
}
