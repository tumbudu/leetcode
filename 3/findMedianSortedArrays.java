// 4. Median of Two Sorted Arrays
// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr1Len = nums1.length;
        int arr2Len = nums2.length;
        
        int totalLen = arr1Len + arr2Len;

        int M1, M2;

        if( totalLen %2 == 0){
            M1 = (totalLen / 2) - 1;
            M2 = (M1 + 1);
        }else{
            M1 = ((totalLen + 1) /2) - 1;
            M2 = M1;
        }

        int i=0; 
        int j=0;
        int k=0;

        int mSum=0;

        for(;;){

            if((i<arr1Len) && (j<arr2Len)){
                if(nums1[i]<nums2[j]){
                    if(k==M1){
                        mSum = mSum + nums1[i];
                    }
                    if(k==M2){
                        mSum = mSum + nums1[i];
                    }
                    i++;
                }else{
                    if(k==M1){
                        mSum = mSum + nums2[j];
                    }
                    if(k==M2){
                        mSum = mSum + nums2[j];
                    }
                    j++;
                }                
            }else if((i<arr1Len) && (j>=arr2Len)){
                if(k==M1){
                    mSum = mSum + nums1[i];
                }
                if(k==M2){
                    mSum = mSum + nums1[i];
                }
                i++;
            }else if((i>=arr1Len) && (j<arr2Len)){
                if(k==M1){
                    mSum = mSum + nums2[j];
                }
                if(k==M2){
                    mSum = mSum + nums2[j];
                }
                j++;
            }

            if(k==M2)
                break;
            k++;
        }

        return (double)mSum / (double)2;

    }
}
