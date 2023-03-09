import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    private List<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> perm = new ArrayList<>(nums.length);

        for (int n : nums) {
            perm.add(n);
        }

        permuteRec(perm, 0, 0);

        return list;
    }

    private void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private void permuteRec(List<Integer> perm, int idx, int size) {
        if (size == perm.size()) {
            list.add(new ArrayList(perm));
            return;
        };

        for (int i = idx; i < perm.size(); i++) {
            swap(perm, idx, i);
            permuteRec(perm, idx + 1, size + 1);
            swap(perm, idx, i);
        }
    }
}
