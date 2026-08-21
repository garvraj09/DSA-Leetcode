class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int lsum = 0, rsum = 0, maxSum = 0;

        for(int i = 0; i < k; i++){
            lsum += cardPoints[i];
        }
        maxSum = lsum;

        int rightIndex = n - 1;

        for(int i = k - 1; i>=0; i--){
            lsum -= cardPoints[i];
            rsum += cardPoints[rightIndex];
            rightIndex--;

            maxSum = Math.max(maxSum, lsum + rsum);
        }
        return maxSum;
    }
}