class Solution {
    public int minimumDeletions(int[] a) {
        int n = a.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int ans = 0;
        int min = a[0];
        int max = a[0];
        int minIdx = 0;
        int maxIdx = 0;
        for(int i = 0; i < n; i++){
            if(a[i] < min){
                min = a[i];
                minIdx = i;
            }
            if(a[i] > max){
                max = a[i];
                maxIdx = i;
            }
        }

        int front = Math.max(minIdx, maxIdx) + 1;

        int back = n - Math.min(minIdx, maxIdx);

        int mixed = (Math.min(minIdx, maxIdx) + 1) + (n - Math.max(minIdx, maxIdx));

        return Math.min(front, Math.min(back, mixed));
    }
}