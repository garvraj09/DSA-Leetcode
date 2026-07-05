class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        int po = 0;
        int ne = 1;
        for(int a : nums){
            if(a > 0){
                arr[po] = a;
                po += 2;
            }else{
                arr[ne] = a;
                ne += 2;
            }
        }
        return arr;
    }
}