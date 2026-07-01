class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;

        // Brute force
        // int sum = 0;
        // for(int i=0;i<n;i++){
        //     int min = arr[i];
        //     for(int j = i; j<n; j++){
        //         min = Math.min(min, arr[j]);
        //         sum = (sum + min) % mod;
        //     }
        // }

        // optimal approach

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
            ans = (ans + ((left * right) % mod) * arr[i]) % mod;
        }

        return (int)ans;
    }
}