class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == ')'){
                Queue<Character> q = new LinkedList<>();
                while(st.peek() != '('){
                    q.add(st.pop());
                }
                st.pop();

                while(!q.isEmpty()){
                    st.push(q.remove());
                }
            }
            else{
                st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}