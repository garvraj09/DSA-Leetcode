class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        if(n == 0) return 0;

        int height[] = new int[m];
        int largest = 0;

        for(int i = 0; i<n ; i++){
            for(int j = 0; j<m; j++){
                int val = matrix[i][j] - '0';
                if(val == 0){
                    height[j] = 0;
                }else{
                    height[j] += val;
                }
            }
            int area = histogram(height);
            largest = Math.max(largest, area);
        }

        return largest;
    }

    private int histogram(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            while (!st.isEmpty() &&
                   (i == n || heights[st.peek()] >= heights[i])) {

                int height = heights[st.pop()];

                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();

                int width = right - left - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}