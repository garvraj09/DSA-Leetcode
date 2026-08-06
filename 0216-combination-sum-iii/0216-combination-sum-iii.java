class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        getAllComb(k, n, 1, ans, comb);
        return ans;
    }

    private void getAllComb(int k, int target, int start, List<List<Integer>> ans, List<Integer> curr){
        if(target == 0 && curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || curr.size() > k) return;

        for(int i = start; i <= 9; i++){
            curr.add(i);

            getAllComb(k, target - i, i + 1, ans, curr);

            curr.remove(curr.size() - 1);
        }
    }
}