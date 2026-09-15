class Solution {
    public int firstMissingPositive(int[] a) {
        int n = a.length;

        //BRUTE FORCE: T.C - O(N) ANS S.C - O(N)
        // Map<Integer, Integer> map = new HashMap<>();

        // int ans = 1;

        // for(int i = 0; i < n; i++){
        //     if(a[i] <= n){
        //         map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        //     }
        // }

        // for(int i = 1; i<= n; i++){
        //     if(!map.containsKey(i)){
        //         ans = i;
        //         break;
        //     }
        //     continue;
        // }
        // return ans;


        // OPTIMISED S.C - O(1)

        for(int i = 0; i < n; i++){
            if(a[i] <= 0 || a[i] > n){
                a[i] = n + 1;
            }
        }

        for(int i = 0; i< n; i++){
            int num = Math.abs(a[i]);

            if(num > n){
                continue;
            }

            if(a[num - 1] > 0){
                a[num - 1] = -a[num - 1];
            }
        }

        for(int i = 0; i < n; i++){
            if(a[i] > 0){
                return i + 1;
            }
        }

        return n + 1;
    }
}