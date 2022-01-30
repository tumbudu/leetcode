// 1. Two Sum
// https://leetcode.com/problems/two-sum/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arrLen = nums.length;
        
        int j=0;
        int i=0;
        int found=0;
        
        for(i=0; i<arrLen; i++){
            for(j=i+1; j<arrLen; j++){
                if(nums[i]+nums[j]==target && i!=j){
                    found=1;
                    break;
                }
            }
            if(found ==1)
                break;
        }
        int[] ans = {i, j};
        return ans;
    }
}
