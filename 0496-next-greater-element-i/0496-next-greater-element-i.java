class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for(int n: nums2){
            while(!s.isEmpty() && s.peek()<n){
                map.put(s.pop(),n);
            }
            s.push(n);
        }

        while(!s.isEmpty()){
            map.put(s.pop(), -1);
        }

        int ans[] = new int[nums1.length];

        for(int i= 0; i<nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}