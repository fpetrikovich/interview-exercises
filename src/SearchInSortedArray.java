public class SearchInSortedArray {

    /**
     * Solucion con un solo binary search, pero el if se vuelve tedioso.
     */
    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        int lVal, rVal, midVal;

        while (l <= r) {
            mid = (l + r) / 2;
            lVal = nums[l];
            rVal = nums[r];
            midVal = nums[mid];

            if (midVal == target) return mid;

            if (lVal > rVal) {

                if ((lVal > midVal && (target >= lVal || target < midVal))
                        || lVal < midVal && target < midVal && target >= lVal) {
                    // vamos a la izquierda
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else {
                // binary search normal
                if (midVal < target) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Solucion con binary search para encontrar el inflection point
     * and the do binary search in the corresponding side.
     */
    public int search(int[] nums, int target) {
        int min = this.findMinIdx(nums);

        if (min > 0 && target >= nums[0]) {
            // Binary search normal a la derecha
            return this.binarySearch(nums, target, 0, min - 1);
        } else {
            // Binary search normal a la izquierda
            return this.binarySearch(nums, target, min, nums.length - 1);
        }
    }

    public int binarySearch(int[] nums, int target, int l, int r) {
        int mid;

        while (l <= r) {
            mid = (l + r) / 2;

            if (nums[mid] == target) return mid;

            if (target < nums[mid]) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public int findMinIdx(int[] nums) {
        int l = 0, r = nums.length - 1, mid;

        // No esta rotated
        if (nums[l] < nums[r]) return 0;

        while (l < r) {
            mid = (l + r) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(l);
        return l;
    }
}
