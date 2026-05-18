// class Solution {
//     public boolean checkValidString(String s) {
//         return backtrack(0,s,new StringBuilder(""));
//     }
//     public boolean backtrack(int i,String s , StringBuilder sb){
//         if(i==s.length()){
//             return checkvalid(sb.toString());
//         }
//         char ch=s.charAt(i);
//         if(ch=='(' || ch==')'){
//             sb.append(ch);
//             boolean ans=backtrack(i+1,s,sb);
//             sb.deleteCharAt(sb.length()-1);
//             return ans;
//         }

//         boolean left=backtrack(i+1,s,sb.append('('));
//         sb.deleteCharAt(sb.length()-1);
//         boolean right=backtrack(i+1,s,sb.append(')'));
//         sb.deleteCharAt(sb.length()-1);
//         boolean empty=backtrack(i+1,s,sb);
//         return left || right || empty;
//     }
//     public boolean checkvalid(String s){
//         Stack<Character> stack=new Stack<>();
//         int i=0;
//         while(i<s.length()){
//             char ch=s.charAt(i);
//             if(ch=='('){
//                 stack.push(ch);
//             }else {
//                 if(stack.isEmpty()){
//                     return false;
//                 }else{
//                     stack.pop();
//                 }
//             }
//             i++;
//         }
//         return stack.isEmpty();
//     }
// }

// class Solution {

//     Boolean[][] dp;

//     public boolean checkValidString(String s) {

//         dp = new Boolean[s.length()][s.length() + 1];

//         return backtrack(0, 0, s);
//     }

//     public boolean backtrack(int i, int open, String s) {
//         if (open < 0) {
//             return false;
//         }
//         if (i == s.length()) {
//             return open == 0;
//         }
//         if (dp[i][open] != null) {
//             return dp[i][open];
//         }
//         char ch = s.charAt(i);
//         boolean ans;
//         if (ch == '(') {
//             ans = backtrack(i + 1, open + 1, s);
//         } else if (ch == ')') {
//             ans = backtrack(i + 1, open - 1, s);
//         } else {
//             ans =
//                 backtrack(i + 1, open + 1, s) || 
//                 backtrack(i + 1, open - 1, s) || 
//                 backtrack(i + 1, open, s); 
//         }

//         return dp[i][open] = ans;
//     }
// }
class chckvalidbracket {
    public boolean checkValidString(String s) {
        int openMin = 0, openMax = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            switch (c) {
                case '(' -> {
                    openMin++;
                    openMax++;
                }
                case ')' -> {
                    openMin = Math.max(openMin - 1, 0);
                    openMax--;
                }
                case '*' -> {
                    openMin = Math.max(openMin - 1, 0);
                    openMax++;
                }
                default -> {
                }
            }
            if (openMax < 0) return false;
        }
        return openMin == 0;
    }
}