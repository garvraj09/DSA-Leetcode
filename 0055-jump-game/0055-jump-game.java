class Solution {
    public boolean canJump(int[] a) {
        int n = a.length;
        int maxIdx = 0;

        for(int i = 0; i < n; i++){
            if(i > maxIdx){
                return false;
            }

            int max = i + a[i];
            maxIdx = Math.max(maxIdx, max);
        }
        return true;
    }
}