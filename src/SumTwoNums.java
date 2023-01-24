import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumTwoNums {

    public int[] twoSumBruteForce(int[] nums, int target) {
        /*
        Brute force
        Time complexity: O(n^2)
        Space complexity: O(1)
         */

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int answer[] = {i, j};
                    return answer;
                }
            }
        }
        return null;
    }

    public int[] twoSumTwoPassHM(int[] nums, int target) {
        /*
        TWO PASS HASH MAP
        Time complexity: O(n) --> Recorremos la tabla en O(n) y el look up time del hash es O(1)
        al menos que haya colisiones.
        Space complexity: O(n)
         */

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            // If the map contains the complement and it is not the one im on
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum(int[] nums, int target) {

        /*
        ONE PASS HASH MAP
        Time complexity: O(n)
        Space complexity: O(n)
        */

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String args[]) {
        int nums[] = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(new SumTwoNums().twoSum(nums, target)));
    }

}
