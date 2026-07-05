class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int can = 0;

        for(int n: nums){
            if(cnt == 0){
                can = n;
            }

            if(n == can){
                cnt++;
            }else{
                cnt--;
            }
        }
        return can;
    }
}