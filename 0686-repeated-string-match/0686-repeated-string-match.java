class Solution {
    public int repeatedStringMatch(String a, String b) {
        int move = 0;
        StringBuilder sb = new StringBuilder();

        while(sb.length() < b.length()){
            sb.append(a);
            move++;
        }

        if(sb.toString().contains(b)){
            return move;
        }

        sb.append(a);
        move++;

        if(sb.toString().contains(b)){
            return move;
        }
        
        return -1;
    }
}