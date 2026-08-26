class Solution {
    public String reverseVowels(String s) {
        char arr[] = s.toCharArray();
        int l = 0;
        int e = s.length() - 1;

        while (l < e) {
            while (l < e && !isVowels(arr[l])) {
                l++;
            }
            while (l < e && !isVowels(arr[e])) {
                e--;
            }

            if (l < e) {
                char temp = arr[l];
                arr[l] = arr[e];
                arr[e] = temp;

                l++;
                e--;
            }
        }

        return new String(arr);
    }

    private boolean isVowels(char c) {
        if (c == 'a' || c == 'A' ||
            c == 'e' || c == 'E' ||
            c == 'i' || c == 'I' ||
            c == 'o' || c == 'O' ||
            c == 'u' || c == 'U') {
            return true;
        }

        return false;
    }
}