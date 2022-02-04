// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
     
        Stack<Character> stack = new Stack<Character>();
        
        int arrLen = s.length();
        
        for(int i=0; i<arrLen; i++){
            char c = s.charAt(i);
            if(stack.size() == 0){
                stack.push(c);
            }else{
                char o = stack.peek();
                if(isClosing(o, c)){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
         }
        if(stack.size() == 0){
            return true;
        }
        return false;
        
    }
    private boolean isClosing(char o, char c){
        if(o=='(' && c==')'){
            return true;
        }else if(o=='{' && c=='}'){
            return true;
        }else if(o=='['&& c==']'){
            return true;
        }
        return false;
    }
}
