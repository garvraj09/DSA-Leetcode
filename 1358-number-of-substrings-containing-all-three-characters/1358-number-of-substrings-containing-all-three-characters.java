class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int res = 0;
        int n = s.length();
        int freq[] = new int[3];

        for(int r = 0; r < s.length(); r++){
            freq[s.charAt(r) - 'a']++;

            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                res += (n - r);

                freq[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return res;
    }
}