// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int strLen = s.length();
        int [] map = new int[200];
            
        int maxLen = 0;
        
        Queue<Character> str = new LinkedList<>();
        
        for(int i=0; i<strLen; i++){
            if(i==0){
                char c = s.charAt(i);
                str.add(c);
                map[c]=1;
                continue;
            }
            
            char c = s.charAt(i);
            
            if(map[c] == 1){
                int ctr= str.size();
                for(;;){
                    char qc = str.remove();
                    map[qc] = 0;
                    if(qc == c)
                        break;
                }
                if(ctr>maxLen){
                    maxLen=ctr;
                }
                str.add(c);
                map[c]=1;
            }else{
                str.add(c);
                map[c] = 1;
            }
        }
        
        if(str.size() > maxLen){
            return str.size();
        }else{
            return maxLen;
        }
    }
}
