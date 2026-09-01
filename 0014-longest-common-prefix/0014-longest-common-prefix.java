class Solution {
    public String longestCommonPrefix(String[] s) {
        if(s.length == 0)  return "";

        String prefix = s[0];

        for(int i = 1; i < s.length; i++){
            String curr = s[i];
            int j = 0;

            while(j < prefix.length() && j < curr.length() && prefix.charAt(j) == curr.charAt(j)){
                j++;
            }

            prefix = prefix.substring(0, j);
        }

        return prefix;
    }
}