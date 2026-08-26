class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int l= 0;
        int r = 0;
        int ones = 0;

        String ans = "";
        while(r < n){
            if(s.charAt(r) == '1'){ ones++; }

            while(ones > k){
                if(s.charAt(l) == '1'){
                    ones--;
                }
                l++;
            }

            if(ones == k){

                while (s.charAt(l) == '0') {
                    l++;
                }
                
                String temp = s.substring(l, r + 1);

                if(ans.isEmpty() || temp.length() < ans.length() || 
                    (temp.length() == ans.length() && temp.compareTo(ans) < 0)){
                    ans = temp;
                }
            }
            r++;
        }
        return ans;
    }
}