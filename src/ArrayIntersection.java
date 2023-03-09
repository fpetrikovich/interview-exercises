import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums2.length < nums1.length) return intersect(nums2, nums1);

        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> intersection = new ArrayList<>(nums1.length);

        for (int n : nums1) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (int n : nums2) {
            int f = freq.getOrDefault(n, 0);

            if (f > 0) {
                intersection.add(n);
                freq.put(n, f-1);
            }
        }

        int[] res = new int[intersection.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = intersection.get(i);
        }
        return res;
    }
}
