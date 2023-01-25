public class MergeSortedArrays {

    /**
     * Time complexity --> O(m+n) given we transverse each array onces.
     * Space complexity --> O(1), only extra space for the indexes.
     *
     * Note: to decrease the space, can change finalp = p1 + p2 + 1
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // will work filling the array from the back
        int p1 = m - 1, p2 = n - 1, finalp = (m + n) - 1;

        while (finalp >= 0) {

            if (p1 < 0) {
                nums1[finalp] = nums2[p2--];
            }
            else if (p2 < 0) {
                nums1[finalp] = nums1[p1--];
            }
            else {
                nums1[finalp] = nums1[p1] > nums2[p2]
                        ? nums1[p1--]
                        : nums2[p2--];
            }
            finalp--;
        }
    }
}
