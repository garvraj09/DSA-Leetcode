class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        //brute:
        // Arrays.sort(nums);
        // long sum = 0;
        // for(int i = 0; i < n; i++){
        //     for(int j = i; j < n; j++){
        //         long range = nums[j] - nums[i];
        //         sum += range;
        //     }
        // }
        // return sum;

        long range = sumSubarrayMaximums(nums) - sumSubarrayMins(nums);
        return range;        
    }

    private long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int prev[] = new int[n];
        int next[] = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && arr[s.peek()] > arr[i]){
                s.pop();
            }

            prev[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        s.clear();

        for(int i = n-1; i >= 0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            next[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        long ans = 0;
        for(int i = 0; i < n; i++){
            long left = i - prev[i];
            long right = next[i] - i;
            ans += left * right * arr[i];
        }

        return ans;
    }

    private long sumSubarrayMaximums(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            ans += left * right * arr[i];
        }

        return ans;
    }
}