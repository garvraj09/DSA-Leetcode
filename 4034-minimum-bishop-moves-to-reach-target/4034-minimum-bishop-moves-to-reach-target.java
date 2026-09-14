class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int s = source[0] + source[1];
        int t = target[0] + target[1];

        int sr = source[0];
        int sc = source[1];

        int tr = target[0];
        int tc = target[1];

        if(s % 2 != t % 2){
            return -1;
        }

        if(Math.abs(sr - tr) == Math.abs(sc - tc)){
            return 1;
        }

        return 2;
    }
}