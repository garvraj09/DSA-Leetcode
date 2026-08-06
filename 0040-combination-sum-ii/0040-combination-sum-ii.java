class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        getComb(candidates, target, ans, 0, comb);
        return ans;
    }

    private void getComb(int[] arr, int target, List<List<Integer>> ans, int index, List<Integer> comb){
        if(target == 0){
            ans.add(new ArrayList<>(comb));
            return;
        }

        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i - 1]){
                continue;
            }

            if(arr[i] > target) break;

            comb.add(arr[i]);

            getComb(arr, target - arr[i], ans, i + 1, comb);

            comb.remove(comb.size() - 1);
        }
    }
}