public class NumberOf1Bit {
    public int hammingWeightShifting(int n) {

        /**
         * Voy shifteando los valores y contando cada vez que encuentro
         * un 1. 010 ==> 001 (a++) ==> 000 termine
         */

        int amount = 0;

        while (n != 0) {
            if ((n & 0x1) == 1) amount++;
            n = n >>> 1;
        }
        return amount;
    }

    public int hammingWeight(int n) {

        /**
         * Cada vez que voy restanto 1, los bits cambian de lugar
         * de tal manera que me voy deshaciendo de 1 bit a la vez.
         * 0101 & 0100 = 0100 / 0100 & 0011 = 0000 ==> 2 loops
         */

        int amount = 0;

        while (n != 0) {
            amount++;
            n = n & (n-1);
        }
        return amount;
    }
}
