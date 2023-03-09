import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {

    /**
     * This one is more understandable, but it uses ArrayList
     * which is slower when manipulating data because it internally
     * uses an array. The add may be O(n) if array has to be copied.
     *
     * To solve this, we can set the capacity of the ArrayList which is
     * how many elements the list can potentially accommodate without
     * reallocating its internal structures. Now everything should be O(1).
     */
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList();
        List<List<Integer>> res = new ArrayList(numRows);

        for(int i = 1; i <= numRows; i++){
            List<Integer> row = new ArrayList(i);
            for(int j = 0 ; j < i ; j++){
                if(j == 0  || j== i-1){
                    row.add(1);
                }else{
                    row.add(res.get(i-2).get(j) + res.get(i-2).get(j-1));
                }
            }
            res.add(row);
        }
        return res;
    }

    /**
     * This one is more confusing, but it uses linked list which has an O(1)
     * add. However, the get is O(n), so I used more storage to store the
     * calculations in an array and have the calculations done in O(1).
     */
    public List<List<Integer>> generate2(int numRows) {

        if (numRows == 0) return new LinkedList<>();

        List<List<Integer>> list = new LinkedList<>();
        int[] aux = new int[numRows];
        int prevVal = 1;
        int currVal;

        list.add(new LinkedList<Integer>(Arrays.asList(1)));

        if (numRows == 1) return list;

        list.add(new LinkedList<Integer>(Arrays.asList(1,1)));

        aux[0] = 1;
        aux[1] = 1;

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new LinkedList<Integer>();

            // First value is always 1
            row.add(1);
            aux[0] = 1;

            // Calculate other values
            for (int j = 1; j < i; j++) {
                currVal = aux[j-1] + aux[j];
                row.add(currVal);
                aux[j-1] = prevVal;
                prevVal = currVal;
            }
            aux[i-1] = prevVal;
            aux[i] = 1;
            row.add(1);

            list.add(row);
        }
        return list;
    }
}
