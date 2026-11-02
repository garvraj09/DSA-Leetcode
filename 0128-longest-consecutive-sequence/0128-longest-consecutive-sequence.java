class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        int longest = 0;
        for(int n : set){
            if(!set.contains(n - 1)){
                int curr = n;
                int count = 1;

                while(set.contains(curr + 1)){
                    curr++;
                    count++;
                }

                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}