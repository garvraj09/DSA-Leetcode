class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count =0;
        for(int x : arr1){
            boolean check = true;
            for(int y : arr2){
                check = check && Math.abs(x - y) > d;
            }
            count += check ? 1 : 0;
        }
        return count;
    }
}