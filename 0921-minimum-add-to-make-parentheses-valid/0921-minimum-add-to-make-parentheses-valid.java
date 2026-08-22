class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                open += 1;
            }
            else if(ch == ')'){
                if(open > 0){
                    open -= 1;
                }
                else{
                    close += 1;
                }
            }
        }
        return open + close;
    }
}