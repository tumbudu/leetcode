// 14. Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String key = new String();
        
        int pos = 0;
        
        int arrLen = strs.length;
        
        for(int i=0; i<arrLen; i++){
            if(i==0){
                key = new String(strs[0]);
                pos = key.length();
                continue;
            }else{
                String str = strs[i];
                int j=0;
                for(j=0; j<pos; j++){
                    if(j>=str.length()){
                        break;
                    }
                    if(str.charAt(j) == key.charAt(j)){
                        continue;
                    }else{
                        break;
                    }
                }
                pos=j;
            }
        }
        return key.substring(0, pos);
    }
}
