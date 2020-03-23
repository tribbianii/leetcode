
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
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }
}