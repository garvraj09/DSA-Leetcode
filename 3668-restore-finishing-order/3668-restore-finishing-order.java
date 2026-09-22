class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = order.length;
        int m = friends.length;

        int res[] = new int[m];

        HashSet<Integer> set = new HashSet<>();

        for(int id : friends){
            set.add(id);
        }

        int a_idx = 0;

        int i = 0;
        while(i < n){
            if(set.contains(order[i])){
                res[a_idx++] = order[i];
            }
            i++;
        }

        return res;
    }
}