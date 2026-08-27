class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // Frequency of characters in s
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // We will store the latest position where
        // we can make the answer greater than target.
        int bestPos = -1;
        int bestChar = -1;
        int[] bestFreq = null;

        for (int i = 0; i < n; i++) {

            int t = target.charAt(i) - 'a';

            // Before using target[i], check if we can put
            // a character slightly greater than target[i].
            for (int c = t + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    // Save this possibility.
                    // We prefer a position farther to the right
                    // because that gives a smaller lexicographical result.
                    bestPos = i;
                    bestChar = c;
                    bestFreq = freq.clone();

                    break;
                }
            }

            // Continue with the same character as target[i]
            if (freq[t] > 0) {
                freq[t]--;
            } else {
                // Cannot make prefix equal to target anymore.
                break;
            }
        }

        // No permutation is greater than target
        if (bestPos == -1) {
            return "";
        }

        // Construct answer
        char[] ans = target.toCharArray();

        // Put the smallest possible greater character
        ans[bestPos] = (char) ('a' + bestChar);
        bestFreq[bestChar]--;

        // Fill remaining positions with smallest characters
        int index = bestPos + 1;

        for (int c = 0; c < 26; c++) {
            while (bestFreq[c] > 0) {
                ans[index++] = (char) ('a' + c);
                bestFreq[c]--;
            }
        }

        return new String(ans);
    }
}