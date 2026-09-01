class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int n = words.length;
        int a = 0;

        for(int i = 0; i < n; i++){
            int cnt = words[i].length();

            if(a + cnt > s.length())  return false;

            if(!s.substring(a, a + cnt).equals(words[i])){
                return false;
            }

            a = a + cnt;

            if(a == s.length()) return true;
        }

        return false;
    }
}