public class PowerOfThree {
    /**
     * Sabemos que un int usa puede ser como mucho 2^31 - 1.
     * Podemos calcular el valor al que elevamos 3 para que de ese numero.
     * Esto nos va a dar nuestro limite superior que podria ser 3^x con x
     * entero. Sabiendo este numero (3^19) y que 3 es primo, sabemos que
     * los unico divisores que tiene son 3^0, 3^1, 3^2, ..., 3^19.
     * Entonces, n deberia ser divisor de 3^19.
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
