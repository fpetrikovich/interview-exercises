
import java.io.*;
import java.util.*;

public class Florida {
    /*
     * Click `Run` to execute the snippet below!
     */


    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */

// N: cantidad de items, M: maxWeight

// int maximizeValue(int[] weights, int[] prices, int maxWeight)
        public static void main(String[] args) {
            ArrayList<String> strings = new ArrayList<String>();
            strings.add("Hello, World!");
            strings.add("Welcome to CoderPad.");
            strings.add("This pad is running Java " + Runtime.version().feature());

            for (String string : strings) {
                System.out.println(string);
            }

            int[] weights = new int[] {4, 2, 2, 1};
            int[] prices  = new int[] {8, 3, 2, 1};
            int maxWeight = 7;

            System.out.println(maxRec(weights, prices, maxWeight, 0, 0));
        }

        public static int maxRec(int[] weights, int[] prices, int maxWeight, int idx, int currWeight) {
            // Base case, fin de la lista or weight
            if (idx >= prices.length) return 0;

            int take = 0;
            if (currWeight + weights[idx] <= maxWeight) take = maxRec(weights, prices, maxWeight, idx + 1, currWeight + weights[idx]) + prices[idx];
            int pass = maxRec(weights, prices, maxWeight, idx + 1, currWeight);

            return Math.max(take, pass);
        }
    }
