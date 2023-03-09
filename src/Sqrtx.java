public class Sqrtx {
    public int mySqrt(int x) {
        // use a binary search to limit the amount of checks

        if (x <= 1) return x;

        // numbers higher than 1 have roots smaller than x/2
        int low = 1, high = x/2;

        while (low <= high) {
            int mid = (int)(low + high) / 2;

            // Division avoids overflow
            if (mid > x / mid) high = mid - 1;
            else {
                if ((mid + 1) > x / (mid + 1)) return mid;
                low = mid + 1;
            }
        }

        return -1;
    }
}
