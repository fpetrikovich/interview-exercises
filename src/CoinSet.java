import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ## The problem
 * # Given a number `x` and a sorted array of coins `coinset`, write a function
 * # that finds a combination of these coins that add up to X
 * # There are an infinite number of each coin.
 * # This is hopefully familiar to making change for a given amount of money in a currency, but it gets more interesting if we remove the 1 coin and have “wrong” coins in the coinset.
 *
 * # Return a map (or dictionary or whatever it is called in your preferred programming language such that each key is the coin, and each value is the number of times you need that coin.
 * # You need to only return a single solution, but for bonus points, return the one with the fewest number of coins.
 * # Don’t worry about performance or scalability for this problem.
 *
 *
 * # # A Specific example
 * # If x=7 and the coinset= [1,5,10,25], then the following are both solutions:
 * # `{1: 7}` since 7*1 = 7
 * # `{1: 2, 5: 1}` since 1*2 + 5*1=7
 *
 * # Some test cases for you to verify your approach works
 * # A. x = 6 coinset = [1,5,10,25]
 * # B. x = 6, coinset = [3,4]
 * # C. x = 6, coinset = [1,3,4]
 * # D. x = 6, coinset = [5,7]
 * # E. x = 16, coinset = [5,7,9]
 *
 */
public class CoinSet {

        // Change with least amount of coins
        private int[] minChange;
        // Minimum amount of coins used to reach a valid change
        private int minCoinsUsed;

        public static void main(String[] args) {

                int testCases = 7;
                int[][] coinSets = new int[testCases][];
                int[] targets = new int[testCases];

                coinSets[0] = new int[] {1,5,10,25};
                targets[0] = 6;
                coinSets[1] = new int[] {3, 4};
                targets[1] = 6;
                coinSets[2] = new int[] {1, 3, 4};
                targets[2] = 6;
                coinSets[3] = new int[] {5, 7};
                targets[3] = 6;
                coinSets[4] = new int[] {5, 7, 9};
                targets[4] = 16;
                coinSets[5] = new int[] {1,5,10,25};
                targets[5] = 16;
                coinSets[6] = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
                targets[6] = 349;

                CoinSet cs = new CoinSet();

                for (int i = 0; i < testCases; i++) {
                        System.out.println(convertMapToStr(cs.makeChange(targets[i], coinSets[i])));
                }
        }

        private static String convertMapToStr(Map<Integer, Integer> map) {
                return map.keySet().stream()
                        .map(key -> key + "=" + map.get(key))
                        .collect(Collectors.joining(", ", "{", "}"));
        }

        private void resetVariables() {
                this.minCoinsUsed = Integer.MAX_VALUE;
                this.minChange = null;
        }
        public Map<Integer, Integer> makeChange(int target, int[] coinSet) {

                resetVariables();

                makeChangeRec(target, coinSet, coinSet.length - 1, new int[coinSet.length], 0);

                Map<Integer, Integer> resultMap = new HashMap<>();
                if (minChange == null) {
                        return resultMap;
                }

                // convert int[] to map ==> add only the coins that have an amount
                for (int i = 0; i < minChange.length; i++) {
                        if (this.minChange[i] > 0) resultMap.put(coinSet[i], this.minChange[i]);
                }

                return resultMap;
        }

        private void makeChangeRec(int target, int[] coinSet, int idx, int[] currChange, int currCoinsUsed) {

                if (currCoinsUsed > this.minCoinsUsed || target < 0) {
                        return;
                }
                if (target == 0) {
                        if (currCoinsUsed < this.minCoinsUsed) {
                                this.minCoinsUsed = currCoinsUsed;
                                this.minChange = Arrays.copyOf(currChange, currChange.length);
                        }
                        return;
                }

                for (int i = idx; i >= 0; i--) {
                        currChange[i]++;
                        makeChangeRec(target - coinSet[i], coinSet, i, currChange, currCoinsUsed + 1);
                        currChange[i]--;
                }
        }
}
