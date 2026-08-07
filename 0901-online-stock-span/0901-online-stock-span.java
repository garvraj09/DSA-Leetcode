class StockSpanner {

    Stack<int[]> s;
    int idx = 0;

    public StockSpanner() {
        s = new Stack<>();
        idx = 0;
    }
    
    public int next(int price) {

        while(!s.isEmpty() && s.peek()[0] <= price){
            s.pop();
        }

        int ans = idx - (s.isEmpty() ? -1 : s.peek()[1]);
        s.push(new int[]{price, idx});

        idx++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */