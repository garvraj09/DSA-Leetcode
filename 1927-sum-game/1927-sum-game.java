class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int ls = 0, rs = 0;
        int lq = 0, rq = 0;

        for(int i = 0 ; i < n/2; i++){
            char ch = num.charAt(i);

            if(ch == '?'){
                lq++;
            }else{
                ls += ch - '0';
            }
        }

        for(int i = n/2 ; i < n; i++){
            char ch = num.charAt(i);

            if(ch == '?'){
                rq++;
            }else{
                rs += ch - '0';
            }
        }

        if((lq + rq) % 2 == 1){
            return true;
        }

        int diff = ls - rs;
        int qdiff = lq - rq;

        return diff != -(qdiff / 2) * 9;
    }
}