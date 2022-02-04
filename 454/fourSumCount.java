// 454. 4Sum II
// https://leetcode.com/problems/4sum-ii/

// Error - Time Limit Exceeded	

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> numIdx1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> numIdx2 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> numIdx3 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> numIdx4 = new HashMap<Integer, Integer>();

        update(numIdx1, nums1);        
        update(numIdx2, nums2);
        update(numIdx3, nums3);
        update(numIdx4, nums4);

        int ctr = 0;
            
        for(Integer i: numIdx1.keySet()){
            for(Integer j: numIdx2.keySet()){
                for(Integer k: numIdx3.keySet()){
                    for(Integer l: numIdx4.keySet()){
                        if(i+j+k+l == 0){
                            int N = numIdx1.get(i) * numIdx2.get(j) * numIdx3.get(k) * numIdx4.get(l);
                            ctr = ctr + N;
                        }
                    }
                }
            }
        }
        return ctr;        
        
    }
    private void update(Map<Integer, Integer> numIdx, int[] nums){

        int arrLen = nums.length;
        for(int i=0; i<arrLen; i++){
            int v = nums[i];
            numIdx.put(new Integer(v), numIdx.getOrDefault(new Integer(v), 0)+1);
        }
    }
}
