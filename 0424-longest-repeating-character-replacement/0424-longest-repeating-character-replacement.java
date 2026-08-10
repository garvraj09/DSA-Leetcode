class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, maxFreq = 0, maxLen = 0;
        int freq[] = new int[26];
        for(int r = 0; r < s.length(); r++){
            freq[s.charAt(r) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);
            // int windowSize = r - l + 1;
            // int charac_need_to_change = windowSize - maxFreq;

            while((r - l + 1) - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}