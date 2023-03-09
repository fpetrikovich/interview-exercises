public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        /**
         * Intuicion:
         * 1. Todo + ==> arreglo entero
         * 2. Algun -
         *   a. Numero par ==> arreglo entero
         *   b. Numero impar ==> tengo que sacar un negativo
         * 3. 0 ==> me corta el subarray y tengo que fijarme en su left y right.
         *
         * Basicamente, la solucion siempre va a empezar en la derecha o izquierda
         * al menos que haya un 0. Si tengo numero impar de negativos y necesito
         * sacar uno, puedo sacar uno del extremo derecho o izquierdo. Si
         * encuentro un 0, reincio el contador a 1 para empezar devuelta la
         * busqueda en el otro lado. Por eso, necesito ir multiplicando del lado
         * del prefijo (left) y sufijo (right).
         */

        int left = 1, right = 1, ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            // Se multiplico por un 0, reiniciar
            if (left == 0) left = 1;
            if (right == 0) right = 1;

            left *= nums[i];
            right *= nums[nums.length - i - 1];

            ans = Math.max(ans, Math.max(left, right));
        }
        return ans;
    }

    public int maxProductBF(int[] nums) {
        /**
         * Brute force
         * Time complexity - O(N^2)
         * Space complexity - O(1)
         */

        int currProd, maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currProd = 1;
            for (int j = i; j < nums.length; j++) {
                currProd *= nums[j];
                maxProd = Math.max(maxProd, currProd);
            }
        }
        return maxProd;
    }
}
