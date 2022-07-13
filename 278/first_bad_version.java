//
//      https://leetcode.com/problems/first-bad-version/
//


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n==1){
            return 1;
        }else if(isBadVersion(n) == false){
            return n;
        }else{
            return firstBadVersion(1, n);
        }
    }
    
    int firstBadVersion(int firstIndex, int lastIndex) {
        if(firstIndex + 1 == lastIndex){
            if( isBadVersion(lastIndex) == true && isBadVersion(firstIndex) == false ){
                return lastIndex;
            }else{
                return firstIndex;
            }
        }if(isBadVersion(lastIndex) == false){
            return lastIndex;
        }else {
            int halfIndex = (lastIndex - firstIndex)/2 + firstIndex;
            
            if(isBadVersion(halfIndex) == true){
                return firstBadVersion(firstIndex, halfIndex);
            }else{
                return firstBadVersion(halfIndex, lastIndex);
            }
        }
    }
}
