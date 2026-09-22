class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int n = words.length;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            boolean consistent = true;
            for(int j = 0; j < words[i].length(); j++){
                if(allowed.indexOf(words[i].charAt(j)) == -1){
                    consistent = false;
                    break;
                }
            }

            if (consistent) {
                cnt++;
            }
        }
        return cnt;
    }
}