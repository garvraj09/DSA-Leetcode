import java.util.*;

class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int halfLen = n / 2;

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        char[] smallestHalf = buildSmallestHalf(halfFreq);

        String smallest = buildPalindrome(
            smallestHalf, middle, n
        );

        if (smallest.compareTo(target) > 0) {
            return smallest;
        }

        char[] targetHalf = new char[halfLen];

        boolean possible = true;
        int[] remaining = halfFreq.clone();

        for (int i = 0; i < halfLen; i++) {

            int c = target.charAt(i) - 'a';

            if (remaining[c] == 0) {
                possible = false;
                break;
            }

            targetHalf[i] = target.charAt(i);
            remaining[c]--;
        }

        if (possible) {

            String palindrome = buildPalindrome(
                targetHalf, middle, n
            );

            if (palindrome.compareTo(target) > 0) {
                return palindrome;
            }
        }

        char[] next = findNextHalf(
            halfFreq, target, halfLen
        );

        if (next == null) {
            return "";
        }

        return buildPalindrome(next, middle, n);
    }

    private char[] buildSmallestHalf(int[] freq) {

        int len = 0;

        for (int x : freq) {
            len += x;
        }

        char[] result = new char[len];

        int index = 0;

        for (int c = 0; c < 26; c++) {
            for (int j = 0; j < freq[c]; j++) {
                result[index++] = (char) ('a' + c);
            }
        }

        return result;
    }

    private char[] findNextHalf(
            int[] halfFreq,
            String target,
            int halfLen) {

        for (int pos = halfLen - 1; pos >= 0; pos--) {

            int[] remaining = halfFreq.clone();

            boolean prefixPossible = true;

            for (int i = 0; i < pos; i++) {

                int c = target.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    prefixPossible = false;
                    break;
                }

                remaining[c]--;
            }

            if (!prefixPossible) {
                continue;
            }

            int targetChar = target.charAt(pos) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (remaining[c] == 0) {
                    continue;
                }

                char[] result = new char[halfLen];

                for (int i = 0; i < pos; i++) {
                    result[i] = target.charAt(i);
                }

                result[pos] = (char) ('a' + c);

                remaining[c]--;

                int index = pos + 1;

                for (int ch = 0; ch < 26; ch++) {
                    while (remaining[ch] > 0) {
                        result[index++] = (char) ('a' + ch);
                        remaining[ch]--;
                    }
                }

                return result;
            }
        }

        return null;
    }

    private String buildPalindrome(
            char[] half,
            char middle,
            int n) {

        StringBuilder sb = new StringBuilder();

        for (char ch : half) {
            sb.append(ch);
        }

        if (n % 2 == 1) {
            sb.append(middle);
        }

        for (int i = half.length - 1; i >= 0; i--) {
            sb.append(half[i]);
        }

        return sb.toString();
    }
}