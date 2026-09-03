class Solution {
    public boolean uniformArray(int[] n1) {
        int n = n1.length;

        boolean isEven = true;
        for(int i : n1){
            if(i % 2 != 0){
                isEven = false;
            }
        }

        if(isEven == true){
            return true;
        }

        int smallest = n1[0];
        for(int i : n1){
            if(i < smallest){
                smallest = i;
            }
        }

        if(smallest % 2 == 1){
            return true;
        }

        return false;
    }
}