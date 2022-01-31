// 1672. Richest Customer Wealth
// https://leetcode.com/problems/richest-customer-wealth/

class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxW=0;
        
        int arrLen = accounts.length;
        
        for(int i=0; i<arrLen; i++){
            int w = sum(accounts[i]);
            
            if(w > maxW){
                maxW = w;
            }
        }
        
        return maxW;
    }
    
    private int sum(int [] array) {
        int arrLen = array.length;
        
        int total=0;
        for(int i=0; i<arrLen; i++){
            total = total+array[i];
        }
        return total;
    }
}
