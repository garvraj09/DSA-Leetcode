class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int c[] = new int[3];
        int l = 0, res = 0 ;

        for(int r = 0 ; r < n ; r++){
            c[s.charAt(r) - 'a']++;

            while(c[0] > 0 && c[1] > 0 && c[2] > 0){
                res += (n - r);

                c[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return res;
    }
}