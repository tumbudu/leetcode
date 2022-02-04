// 13. Roman to Integer
// https://leetcode.com/problems/roman-to-integer/

class Solution {
    public int romanToInt(String s) {
       Map<String, Integer> vmap = new HashMap<>();

        vmap.put("I", 1);
        vmap.put("V", 5);
        vmap.put("IV", 4);
        vmap.put("X", 10);        
        vmap.put("IX", 9);
        vmap.put("L", 50);        
        vmap.put("XL", 40);
        vmap.put("C", 100);
        vmap.put("XC", 90);
        vmap.put("D", 500);        
        vmap.put("CD", 400);
        vmap.put("M", 1000);
        vmap.put("CM", 900);

        int sum = 0;
        int arrLen = s.length();
        
        for(int i=0; i<arrLen; i++){
            String s1, s2;         

            char c = s.charAt(i);

            s1 = Character.toString(c);
            s2 = s1; 
             
            if(i+1 < arrLen){
                s2 = s1+ Character.toString(s.charAt(i+1));
            }
            
            if(vmap.containsKey(s2)){       
                sum = sum + vmap.get(s2);
                i++;
            }else{
               sum = sum + vmap.get(s1);
            }
        }
        return sum;
        
    }
}
