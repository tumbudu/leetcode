// 525. Contiguous Array
// https://leetcode.com/problems/contiguous-array/

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int arrLen = nums.length;
        int sum=0;
        int max=0;
        
        for(int i=0; i<arrLen; i++){
            
            sum = sum + ((nums[i]==0)? -1:1);

            if(map.containsKey(sum)){
                max = Math.max(max, i - map.get(sum));
            }else{
                map.put(sum, i);
            }        
        }
        return max;
    }
}
