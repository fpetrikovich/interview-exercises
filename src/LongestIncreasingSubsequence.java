import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        int currIdx = 0, idx;

        int[] trace = new int[nums.length];
        int[] sub = new int[nums.length];
        int[] subIndex = new int[nums.length];
        Arrays.fill(trace, -1);

        for (int i = 0; i < nums.length; i++) {

            // If we are in the first number or the number is larger than the last of the subsequence
            if (i == 0 || sub[currIdx - 1] < nums[i]) {
                // System.out.println("CASE ONE " + nums[i]);
                if (currIdx > 0) {
                    trace[i] = subIndex[currIdx - 1];
                }
                subIndex[currIdx] = i;
                sub[currIdx++] = nums[i];
            }
            // If not larger, find the smallest number that is larger than nums[i] to
            // replace it with nums[i]
            else {
                // System.out.println("CASE TWO " + nums[i]);
                idx = bisect_left(sub, currIdx, nums[i]);
                // System.out.println(idx);
                // System.out.println(nums[i]);
                // System.out.println(Arrays.toString(sub));
                // Prev element index is the value to the left of subIndex[idx]
                if (idx > 0) {
                    trace[i] = subIndex[idx - 1];
                }
                sub[idx] = nums[i];
                subIndex[idx] = i;
            }
        }
        // System.out.println(Arrays.toString(subIndex));
        // System.out.println(Arrays.toString(trace));
        // System.out.println(currIdx);
        // [3,5,6,2,5,4,19,5,6,7,12]

        List<Integer> path = new LinkedList<Integer>();
        // Get index of last value of the subset
        int pathIdx = subIndex[currIdx-1];

        // When we reach an index of -1 we will have reached the end
        while (pathIdx >= 0) {
            // System.out.println(pathIdx);

            path.add(nums[pathIdx]);
            pathIdx = trace[pathIdx];
        }

        Collections.reverse(path);
        System.out.println("After Reverse ArrayList:");
        System.out.println(path);

        return path.size();
    }

    public static int bisect_left(int[] A, int len, int x) {
        return bisect_left(A, x, 0, len - 1);
    }

    public static int bisect_left(int[] A, int x, int lo, int hi) {
        int N = A.length, mid = 0;
        if (N == 0) {
            return 0;
        }
        while (lo <= hi) {
            mid = (hi + lo) / 2;

            if (x == A[mid]) {
                return mid;
            } else if (x > A[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (A[mid] <= x) return mid + 1;
        return mid;
    }
}