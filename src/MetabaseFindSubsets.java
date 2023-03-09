import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * def subsets(set):
 *   pass
 *
 * subsets([])        # -> [[]]
 * subsets([1])       # -> [[], [1]]
 * subsets([1, 2])    # -> [[], [1], [2], [1, 2]]
 * subsets([1, 2, 3]) # -> [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
 */
public class MetabaseFindSubsets {

    List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(18);
        set.add(37);

        createSubsets(set);
    }

    public static void createSubsets(List<Integer> set) {

        createSubsetsRec(set, new ArrayList<>(set.size()), 0);
    }

    public static void createSubsetsRec(List<Integer> set, List<Integer> currSubset, int idx) {

        if (idx == set.size()) {
            System.out.println(currSubset);
            return;
        }

        // Ignore the element
        createSubsetsRec(set, currSubset, idx + 1);

        // Add the element
        currSubset.add(set.get(idx));
        createSubsetsRec(set, currSubset, idx + 1);
        currSubset.remove(currSubset.size()-1);

    }
}
