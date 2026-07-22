class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        if(n == k){
            return Arrays.stream(cardPoints).sum();
        }

        int totalsum = 0;

        for(int i: cardPoints){
            totalsum += i;
        }

        int windowSize = n - k;

        int windowSum = 0;

        for(int i = 0; i<windowSize ; i++){
            windowSum += cardPoints[i];
        }

        int minWindowSum = windowSum;

        for(int i = windowSize; i < n; i++){
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];

            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        return (totalsum - minWindowSum);
    }
}