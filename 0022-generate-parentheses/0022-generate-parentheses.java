class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate("", 0, 0, n, list);
        return list;
    }

    private void generate(String curr, int open, int close, int total, List<String> list){
        if(curr.length() == 2 * total){
            list.add(curr);
            return;
        }

        if(open < total){
            generate(curr + "(", open + 1, close, total, list);
        }

        if(close < open){
            generate(curr + ")", open, close + 1, total, list);
        }
    }
}