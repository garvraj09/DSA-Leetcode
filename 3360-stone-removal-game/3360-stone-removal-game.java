class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10){
            return false;
        }
        int i = 10;
        int turn = 0;
        while(n >= i){
            n = n - i;
            i--;
            turn++;
        }
        return (turn % 2) == 1;
    }
}