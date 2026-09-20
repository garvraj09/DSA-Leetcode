class Solution {
    public int reverseDegree(String s) {
        int sum =0;

        for(int i = 0; i < s.length(); i++){
            int alphaPos = s.charAt(i) - 'a' + 1;
            int reversePos = 27 - alphaPos;

            int stringPos = i + 1;

            sum += stringPos * reversePos;
        }

        return sum;
    }
}