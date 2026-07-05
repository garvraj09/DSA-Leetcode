class Solution {
    public void sortColors(int[] nums) {
        int cnt_z=0, cnt_o=0, cnt_t = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0){
                cnt_z++;
            }else if(nums[i] == 1){
                cnt_o++;
            }else
            cnt_t++;
        }
        for(int i = 0 ; i < cnt_z ; i++){
            nums[i]=0;
        }
        for(int i = cnt_z ; i < cnt_z+cnt_o ; i++){
            nums[i]=1;
        }
        for(int i = cnt_z+cnt_o ; i < n ; i++){
            nums[i]=2;
        }
    }
}