class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;

        int []a = new int[n];
        a[0] = pref[0];

        for(int i = 1; i < n; i++){
            a[i] = pref[i] ^ pref[i - 1];
        }

        return a;
    }
}