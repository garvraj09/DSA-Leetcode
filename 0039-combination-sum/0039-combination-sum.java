class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        int i = 0;

        getAllComb(candidates, target, i, ans, comb);
        return ans;
    }

    HashSet<List<Integer>> set = new HashSet<>();
    void getAllComb(int[] arr, int target, int i, List<List<Integer>> ans, List<Integer> comb){

        if(i == arr.length || target < 0){
            return;
        }

        if(target == 0){
            if(!set.contains(comb)){
                ans.add(new ArrayList<>(comb));
                set.add(new ArrayList<>(comb));
            }
            return;
        }

        comb.add(arr[i]);
        getAllComb(arr, target - arr[i], i + 1, ans, comb);
        getAllComb(arr, target - arr[i], i, ans, comb);

        comb.remove(comb.size() - 1);
        getAllComb(arr, target, i + 1, ans, comb);
    }
}