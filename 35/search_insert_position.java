//  https://leetcode.com/problems/search-insert-position/


class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = nums.length-1;
        if(nums[index] == target){
            return index;
        }else if(nums[index] < target){
            return index+1;
        }else{
            return searchInsert(nums, target, 0, index);
        }
    }
    int searchInsert(int[] nums, int target, int startIndex, int lastIndex){
        
      if(nums[lastIndex] == target){
          return lastIndex;
      }else if(nums[startIndex] == target) {
          return startIndex;
      }else if(startIndex + 1 == lastIndex){
          if(nums[startIndex] > target){
              return startIndex;
          }else{
              return lastIndex;
          }
      }else if(startIndex == lastIndex && nums[startIndex] > target){
          return lastIndex;
      }else{
          int halfIndex = (lastIndex - startIndex)/2 + startIndex;
          
          if(nums[halfIndex] == target){
              return halfIndex;
          }else if(nums[halfIndex] > target){
              return searchInsert(nums, target, startIndex, halfIndex); 
          }else{
              return searchInsert(nums, target, halfIndex, lastIndex); 
          }
      }
    }
}
