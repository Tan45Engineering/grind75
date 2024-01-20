/*You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.



Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class _14FirstBadVersion {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid = 0;

        //use binary search to find the first bad version within the range (low to high)
        while(low <= high){
            mid = low + (high-low)/2;

            if(isBadVersion(mid)){
                high = mid-1; // the bad version is in the left half, so update the upper bound
            }else{
                low = mid + 1; //the bad version is in the right half, so update the lower bound
            }
        }

        return low; //when the loop end, 'low' will be pinting at the first bad version

    }

    /*dummy code, not part of the solution*/
    private boolean isBadVersion(int mid) {
        return true;
    }
}

//1 2 3 4 5 6 7 8 9 10 11 12
