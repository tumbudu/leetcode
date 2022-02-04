// 9. Palindrome Number
// https://leetcode.com/problems/palindrome-number/

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else{
            String intStr = String.valueOf(x);
            int arrLen = intStr.length();
            
            boolean panlindrome = true;
            int i=0;
            int j=arrLen -1;  
            
            for(; ;){
                if(intStr.charAt(i) == intStr.charAt(j) ){
                    i++;
                    j--;
                }else{
                    panlindrome = false;
                    break;
                }             
                if(j<i){
                    break;
                }
            }
            
            return panlindrome;
        }
    }
}
