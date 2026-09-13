class Solution {

    private int countOverlaps(int[][] a, int[][] b, int row_off, int col_off){
        int n = a.length;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                
                // finding b indexes
                int b_i = i + row_off;
                int b_j = j + col_off;

                // check if the indexes of b are valid or not
                if(b_i < 0 || b_i >= n || b_j < 0 || b_j >= n){
                    continue;
                }

                if(a[i][j] == 1 && b[b_i][b_j] == 1){
                    cnt++;
                }
            }
        }

        return cnt;
    }


    public int largestOverlap(int[][] a, int[][] b) {
        int n = a.length;

        int max = 0;
        for(int row_off = (-n+1) ; row_off < n; row_off++){
            for(int col_off = (-n+1) ; col_off < n; col_off++){
                int count = countOverlaps(a, b, row_off, col_off);

                max = Math.max(max, count);
            }
        }
        return max;
    }
}