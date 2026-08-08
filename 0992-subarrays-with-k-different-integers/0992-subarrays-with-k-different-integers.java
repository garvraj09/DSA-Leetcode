class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return (find(nums, k) - find(nums, k-1));
    }

    private int find(int arr[], int k){
        int l=0, r=0, cnt=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r < arr.length){
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);

            while(map.size() > k){
                map.put(arr[l], map.get(arr[l]) - 1);

                if(map.get(arr[l]) == 0){
                    map.remove(arr[l]);
                }
                l++;
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
}