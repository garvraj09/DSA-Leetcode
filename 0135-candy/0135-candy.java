class Solution {
    public int candy(int[] r) {
        int n = r.length;
        int candy[] = new int[n];

        for(int i = 0; i<n; i++){
            candy[i] = 1;
        }

        for(int i = 1 ; i<= n-1; i++){
            if(r[i] > r[i - 1]){
                candy[i] = candy[i-1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(r[i] > r[i+1]){
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        int total = 0;
        for(int i : candy){
            total += i;
        }

        return total;
    }
}