class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int start = 0;

        while (start < n) {
            int end = start;

            while (end + 1 < n &&
                   nums[indices[end + 1]] - nums[indices[end]] <= limit) {
                end++;
            }

            List<Integer> positions = new ArrayList<>();
            List<Integer> values = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                positions.add(indices[i]);
                values.add(nums[indices[i]]);
            }

            Collections.sort(positions);

            for (int i = 0; i < positions.size(); i++) {
                nums[positions.get(i)] = values.get(i);
            }

            start = end + 1;
        }

        return nums;
    }
    }
