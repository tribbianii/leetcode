
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
package leetcode;

public class BinarySearchFirstBadVersion{
    int firstBadVersion;
    public boolean isBadVersion(int n){
        if (n==firstBadVersion){
            return true;
        }
        return false;
    }
    //API implemented above

    public int firstBadVersion(int n) {
        if (n<=1){
            return 1;
        }
        else{
            return check(1,n);
        }
    }
    public int check(int start, int end){
        if (start==end){
            return start;
        }
        int target = start+(end-start)/2;
        if (!isBadVersion(target)){
            return check(target+1,end);
            //because x/2 operation will return integer value equal or less than float(x/2
            //when end-start=1, pos will stay at start due to /2 operation
            //so start should move forward one
        }
        else {
            return check(start,target);
        }
    }
}