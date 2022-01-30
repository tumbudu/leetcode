// 189. Rotate Array
// https://leetcode.com/problems/rotate-array/

class Solution {
    public void rotate(int[] nums, int k) {
        int arrLen = nums.length;
        
        if(arrLen==0)
            return;
        if(arrLen==1)
            return;
        
        int kNew = arrLen - (k % arrLen);

        int tmp[] = new int[arrLen];
        System.arraycopy(nums, kNew, tmp, 0, arrLen-kNew);
        System.arraycopy(nums, 0, tmp, arrLen-kNew, kNew);
        System.arraycopy(tmp, 0, nums, 0, arrLen);

        nums = tmp;
        tmp = null;
    }
    
    private void rotate_r_1(int[] nums) {
    int len = nums.length;
    int replace = nums[len-1];
    int tmp = replace;
    for(int i=0; i<len; i++){
        tmp = nums[i];
        nums[i]=replace;
        replace = tmp;
    }
}
}


